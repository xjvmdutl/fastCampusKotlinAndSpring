package com.fastcampus.springwebflux.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    doSomething() //suspend를 일반 함수에서 사용할 수 없다.
    //코루틴 스코프안에서만 사용이 가능
}

fun printHello() = println("hello")

suspend fun doSomething() = coroutineScope{//RunBlocking 과는 달리 현재 스레드가 블록킹되지 않고 스레드가 동작한다.
    launch {
        delay(200)
        println("world!")
    }
    launch {
        printHello()
    }
}