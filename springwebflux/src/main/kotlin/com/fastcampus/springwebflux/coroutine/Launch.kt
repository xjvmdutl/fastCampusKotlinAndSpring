package com.fastcampus.springwebflux.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    /*
    launch { //비동기 실행, job이라는 특별한 값 반호나
        delay(500) //코루틴에서 제공하는 일시 중단 함수로, 스레드를 차단하지 않고 일시중지된다.
        //Thread.sleep(500)
        println("World")
    }
    println("Hello")
    //launch를 비동기로 실행하고, hello를 출력한 뒤, 500MS 이후 World를 출력한다.
     */
    val job1:Job = launch {//launch 를 여러개 써서 병렬적으로 동작시킬 수 있다
        val elapsedTime = measureTimeMillis {
            delay(150)
        }
        println("async task-1 $elapsedTime ms")
    }
    //job1.cancel() //job을 받아 해당 비동기 로직을 조절할 수 잇다

    val job2:Job = launch(start = CoroutineStart.LAZY) { //실제 사용시점까지 미룬다,
        val elapsedTime = measureTimeMillis {
            delay(100)
        }
        println("async task-2 $elapsedTime ms")
    }
    println("start task-2")
    job2.start()
}