package com.fastcampus.userservice.service

import com.fastcampus.userservice.config.JWTProperties
import com.fastcampus.userservice.domain.entity.User
import com.fastcampus.userservice.domain.repository.UserRepository
import com.fastcampus.userservice.exception.InvalidJwtTokenException
import com.fastcampus.userservice.exception.PasswordNotMatchedException
import com.fastcampus.userservice.exception.UserExistsException
import com.fastcampus.userservice.exception.UserNotFoundException
import com.fastcampus.userservice.model.SignInRequest
import com.fastcampus.userservice.model.SignInResponse
import com.fastcampus.userservice.model.SignUpRequest
import com.fastcampus.userservice.utils.BCryptUtils
import com.fastcampus.userservice.utils.JWTClaim
import com.fastcampus.userservice.utils.JWTUtils
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {


    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

    suspend fun signUp(signModel: SignUpRequest) {
        with(signModel) {

            userRepository.findByEmail(email)?.let { throw UserExistsException() }
            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username
            )
            userRepository.save(user)
        }
    }

    suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return with(
            userRepository.findByEmail(signInRequest.email) ?: throw UserNotFoundException()
        ) {
            val verified = BCryptUtils.verity(signInRequest.password, password)
            if (!verified)
                throw PasswordNotMatchedException()
            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username
            )
            val token = JWTUtils.createToken(
                claim = jwtClaim,
                properties = jwtProperties
            ) //토큰을 서버에서 보관하고 있어야한다
            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)
            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }

    suspend fun logout(token: String) {
        cacheManager.awaitEvict(token)//캐시를 삭제하는 함수
    }

    suspend fun getByToken(token: String): User {
        //캐시 조회(없으면 복호화된 값 반환)
        val cacheUser = cacheManager.awaitGetOrPut(key = token, ttl = CACHE_TTL) {
            //캐시가 유효하지 않은 경우 동작
            val decodedJWT = JWTUtils.decode(token, jwtProperties.secret, jwtProperties.issuer)

            val userId = decodedJWT.claims["userId"]?.asLong() ?: throw InvalidJwtTokenException()
            get(userId)
        }
        return cacheUser
    }

    suspend fun get(userId: Long): User {
        return userRepository.findById(userId) ?: throw UserNotFoundException()
    }

    suspend fun edit(token: String, username: String, profileUrl: String?): User {
        val user = getByToken(token)
        val newUser = user.copy(username = username, profileUrl = profileUrl ?: user.profileUrl)

        return userRepository.save(newUser).also {
            cacheManager.awaitPut(key = token, value = it, ttl = CACHE_TTL)
        }
    }
}