package com.fastcampus.userservice.exception

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.mono
import mu.KotlinLogging
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Configuration
class GlobalExceptionHandler(
    private val objectMapper: ObjectMapper,
) : ErrorWebExceptionHandler {
    private val logger = KotlinLogging.logger {}
    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> = mono {
        //mono라는 코루틴 빌더를 사용하면, mono안에서 코루틴을 사용할 수 있다.
        logger.error { ex.message }
        val errorResponse = if (ex is ServerException) {
            ErrorResponse(code = ex.code, message = ex.message)
        } else { //정의하지 않은 오류
            ErrorResponse(code = 500, message = "Internal Server Error")
        }
        with(exchange.response){
            statusCode = HttpStatus.OK
            headers.contentType = MediaType.APPLICATION_JSON
            val dataBuffer = bufferFactory().wrap(objectMapper.writeValueAsBytes(errorResponse))
            writeWith(dataBuffer.toMono()).awaitSingle() //코루틴으로 변환
        }
    } //Exception 핸들링 객체
}