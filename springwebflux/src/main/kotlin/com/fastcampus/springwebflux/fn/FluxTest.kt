package com.fastcampus.springwebflux

import com.fastcampus.springwebflux.Currency.KRW
import reactor.core.publisher.Flux

data class CellPhone(
    val name: String,
    val price: Int,
    val currency: Currency,
)

enum class Currency {
    KRW, USD
}

fun main() {
    val iphone = CellPhone(name = "iphone", price = 100, currency = KRW)
    val galaxy = CellPhone(name = "galaxy", price = 90, currency = KRW)
    val flux = Flux.just(iphone, galaxy)
    flux.subscribe(::println)
}