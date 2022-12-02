package thread

fun main() {
    for (i in 0..5) {
        val thread = Thread {
            println("current-thread-name: ${Thread.currentThread().name}")
        }
        thread.start()
    }
    println("current-thread-name: ${Thread.currentThread().name}") //main 스레드 출력 -> 프로그래밍 실행될 때 가장 기본으로 실행되는 스레드
}