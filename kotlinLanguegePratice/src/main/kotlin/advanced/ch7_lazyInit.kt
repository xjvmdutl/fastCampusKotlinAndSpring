package advanced

class HelloBot {
    //var greeting: String? = null
    val greeting: String by lazy(/*LazyThreadSafetyMode.NONE*/) {
        //LazyThreadSafetyMode.NONE 가 설정되어 있다면, 멀티스레드에 안전하지 않다
        //LazyThreadSafetyMode.PUBLICATION 으로 설정되어 있다면, 동기화가 되지 않고 동작한다.
        println("초기화 로직 수행")
        getHello()
    } //불변을 유지하면서 초기화를 유지 할 수 있다.

    //by lazy를 사용하면, var를 사용할 수 없다
    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    /*
    //코드의 문제점 : HelloBot에 있는 변수가 가변변수(var)로 선언되어 있다.
    //지연 할당의 쓰려면 가변변수 밖에 쓸 수 없다 -> 코틀린은 by lazy를 사용한다.
    val helloBot = HelloBot()

    //... 특정 로직이 있다고 가정

    //helloBot.greeting = getHello()
    helloBot.sayHello()
    helloBot.sayHello()
    helloBot.sayHello()
     */
    val helloBot = HelloBot()
    //... 특정 로직이 있다고 가정
    for (i in 1..5) {
        Thread {
            helloBot.sayHello()//여러번 실행해도 초기화 로직은 한번만 실행된다(멀티 스레드에 안전하다)
        }.start()
    }
}