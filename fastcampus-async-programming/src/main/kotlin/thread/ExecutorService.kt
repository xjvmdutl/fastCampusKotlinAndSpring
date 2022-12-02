package thread

import java.util.concurrent.Executors

fun main() {
    val pool = Executors.newFixedThreadPool(5) //Executor Service에서 스레드를 꺼내오는 펙토리 메서드, 파라미터 값은 스레드의 유지 갯수
    try {
        for (i in 0..5) {
            pool.execute {
                println("current-thread-name : ${Thread.currentThread().name}")
            }
        }
    }finally {
        pool.shutdown()
    }
    println("current-thread-name : ${Thread.currentThread().name}")
}