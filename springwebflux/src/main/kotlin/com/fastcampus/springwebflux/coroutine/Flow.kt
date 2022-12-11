package com.fastcampus.springwebflux.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val flow = simple()
    //flow.collect { value -> println(value) }
    println(flow) //참조값만 출력되고 코드가 동작하지 않는다(최종 연산자를 호출해야지만, 호출되기 떄문)
}

fun simple(): Flow<Int> = flow {
    println("Flow started")

    for (i in 1..3) {
        delay(100)
        emit(i) //데이터 통지
    }
}