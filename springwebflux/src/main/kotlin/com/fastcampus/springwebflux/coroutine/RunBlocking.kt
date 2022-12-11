package com.fastcampus.springwebflux.coroutine

import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {// 코루틴을 생성하는 코루틴 빌더, 런블록킹 함수로 감싼 코드는 코루틴 내부에 코드가 끝날때 까지 해당 스레드를 블록킹한다.
        //일반적인 코드(스프링 MVC, 스프링 배치)와 같은 코드를 실행시킬때 사용한다.
        println("Hello ")
        println("Thread : ${Thread.currentThread().name} ") //실행 옵션에 coroutine 옵션을 켜야지만 보인다.
    }
    println("World")
    println(Thread.currentThread().name)
}