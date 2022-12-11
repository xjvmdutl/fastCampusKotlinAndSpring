package com.fastcampus.springwebflux.book

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import java.util.concurrent.atomic.AtomicInteger

data class Book(val id: Int, val name: String, val price: Int)

@Service
class BookService {
    private final val nextId = AtomicInteger(0)
    val books = mutableListOf(
        Book(id = nextId.incrementAndGet(), name = "코틀린 인 액션", price = 30000),
        Book(id = nextId.incrementAndGet(), name = "HTTP 완벽 가이드", price = 40000),
    )

    fun getAll(): Flux<Book> {
        //return Flux.fromIterable(books)
        return books.toFlux() //코틀린에서는 펙토리 함수가 아닌 확장함수를 통해 flux로 변환을 해주는 함수가 존재한다.
    }

    fun get(id: Int): Mono<Book> {
        return Mono.justOrEmpty(books.find { it.id == id })
    }

    fun add(request: Map<String, Any>): Mono<Book> {
        return Mono.just(request)
            .map { map ->
                val book = Book(
                    id = nextId.incrementAndGet(),
                    name = map["name"].toString(),
                    price = map["price"] as Int
                )
                books.add(book)
                book
            }
    }

    fun delete(id: Int): Mono<Void> {
        return Mono.justOrEmpty(books.find { it.id == id })
            .map { books.remove(it) }
            .then() //then을 통해 mono을 Void로 반환
    }
}