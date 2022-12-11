package com.fastcampus.springwebflux.book

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class BookController(
    private val bookService: BookService,
) {
    @GetMapping("/books")
    fun getAll(): Flux<Book> { //스프링에서 반환 타입이, Flux,Subscribe 일 경우 알아서 subscribe를 호출해준다.
        return bookService.getAll()
    }

    @GetMapping("/books/{id}")
    fun get(@PathVariable id: Int): Mono<Book> {
        return bookService.get(id)
    }

    @PostMapping("/books")
    fun add(@RequestBody request: Map<String, Any>): Mono<Book> {
        return bookService.add(request)
    }

    @DeleteMapping("/books/{id}")
    fun delete(@PathVariable id: Int): Mono<Void> {
        return bookService.delete(id)
    }
}