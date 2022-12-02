package com.fastcampus.springwebflux

import reactor.core.publisher.Mono

fun main(){
    val mono = Mono.just("Hello Reactive World")
    //mono.subscribe(::println) //해당 함수가 호출되기 전에 Hello Reactive World가 출력되지 않는다
    println(mono)
}