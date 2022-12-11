package com.fastcampus.springwebflux.webclient

import com.fastcampus.springwebflux.book.Book
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpMethod.GET
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import java.lang.reflect.ParameterizedType

@RestController
class WebClientExample {
    //RestTemplate 은 더이상 사용되지 않는 duplicate 되었다
    val url = "http://localhost:8080/books"

    val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/books/block")
    fun getBooksBlockingWay(): List<Book> {
        log.info("Start RestTemplate")
        val restTemplate = RestTemplate()

        val response = restTemplate.exchange(url, GET, null,
            object : ParameterizedTypeReference<List<Book>>() {})
        //RestTemplate는 코드가 순차적으로 흐르기 때문에 코드를 파악하기는 쉽지만, API를 호출하게된다면, 그 순간 스레드가 Blocking 되기 떄문에 다른일을 하지 못한다.

        val response1 = restTemplate.exchange(url, GET, null,
            object : ParameterizedTypeReference<List<Book>>() {})

        val response2 = restTemplate.exchange(url, GET, null,
            object : ParameterizedTypeReference<List<Book>>() {})
        //복수개의 RestTemplate 가 있다면, 최악의 상황도 나올 수 있기 때문에, 지향하지 않는다

        val result = response.body!!
        log.info("result: {}", result)
        log.info("Finish RestTemplate")
        return result
    }

    //WebClient 같은 경우 Blocking/Non-Blocking 모두 지원하여, 컨텍스트 스위칭이 줄어 메모리 전략이 가능하며, 동시에 여러서버로 호출이 가능하기 때문에 빠르게 처리가 가능하다는 장점이 있다.
    @GetMapping("/books/nonblock")
    fun getBooksNonBlockingWay(): Flux<Book> {
        log.info("Start WebClient")
        val flux = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToFlux(Book::class.java)
            .map {
                log.info("result: {}", it)
                it
            }
        log.info("Finish WebClient") //해당 로그가 먼저 찍힌다(non-blocking)
        return flux
    }

}