package com.fastcampus.springwebflux.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sum(a: Int, b: Int) = a + b
//코틀린은 async / await를 키워드가 아닌 함수로 제공한다
fun main() = runBlocking<Unit> {
    val result1 = async { //Deferred 라는 특별한 타입을 반환하고, 결과를 받아올 수 있는 await 함수를 제공한다.
        delay(100)
        sum(1, 3)
    }
    println("result1 : ${result1.await()}") //await 함수를 통해 비동기 결과를 사용할 수 있다.

    val result2 = async {
        delay(100)
        sum(2, 5)
    }
    println("result2 : ${result2.await()}")
}
