package fastcampus.issueservice.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice //Spring 에서 controller에서 발생하는 오든 오류를 알 수 있다.
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException): ErrorResponse {
        logger.error { ex.message } //에러 로그 발생
        return ErrorResponse(
            code = ex.code,
            message = ex.message
        )
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(ex: TokenExpiredException): ErrorResponse {
        logger.error { ex.message } //에러 로그 발생
        return ErrorResponse(
            code = 401,
            message = "Token Expired Error"
        )
    }

    @ExceptionHandler(Exception::class) //정의하지 않은 에러
    fun handleException(ex: Exception): ErrorResponse {
        logger.error { ex.message } //에러 로그 발생
        return ErrorResponse(
            code = 500,
            message = "Internal Server Error" //ex.message 를 그대로 내려주게 되면, stacktrace 로그가 바로 전달되기 때문에 로거를 통해서만 볼수 있도록 해야한다
        )
    }
}