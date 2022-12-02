package thread

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun sum(a: Int, b: Int) = a + b

fun main() {
    val pool = Executors.newSingleThreadExecutor()
    val future = pool.submit(Callable {
        sum(100, 200)
    })
    println("계산 시작")
    val futureResult = future.get() //비동기 작업을 결과를 기다린다.
    // get 함수를 사용하게 되면 스레드가 작업을 완료할 때까지 스레드가 블록킹 된다
    println(futureResult)
    println("계산 종료")
}