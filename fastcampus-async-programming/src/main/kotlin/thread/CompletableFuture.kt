package thread

import java.util.concurrent.CompletableFuture

//CompletableFuture를 사용해서 자바에서 비동기 논 블로킹 작업을 쉽게 구현할 수 있다.
fun main() {
    val completableFuture = CompletableFuture.supplyAsync {
        Thread.sleep(2000)
        sum(100, 200)
    }

    println("계산 시작")
    completableFuture.thenApplyAsync(::println) //논 블로킹으로 동작

    /*
    val result = completableFuture.get() //블로킹 동작
    println(result)
     */

    while (!completableFuture.isDone) { //종료 될때까지 대기
        //completableFuture.isCancelled //취소 여부
        //completableFuture.isCompletedExceptionally //오류 발생 여부
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다.")
    }
    println("계산 종료")
}