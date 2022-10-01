package basic

fun main() {
    //Thread.sleep(1000); //컴파일 오류 안난다
    try {
        //Thread.sleep(1000)
        throw Exception()
    } catch (e: Exception) { //직접 예외 처리를 할 수도 있다.
        println("에러 발생!")
    } finally {
        println("finally 실행!") //JAVA와 마찬가지로 finally를 동작시킬 수 있다
    }

    //코틀린에서는 try-catch 가 표현식이다.
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        //예외가 발생하면, Unit을 반환한다.
        println("예외 발생 !")
    }
    println(a)

    //throw Exception("예외 발생!") //코틀린에서 예외를 발생하기 위해서는 throw 키워드를 사용하면 된다.

    //failFast("예외 발생!!")
    //println("이 메시지는 출력 될까?") //컴파일러가 해당 문장은 실행되지 않는다는 경고를 보여주게 된다. //Nothing 타입을 보고 판단.

    val b: String? = null
    val c = b ?: failFast("a is null") //엘비스 연산자와 Nothing 타입을 같이 사용하는 경우 반드시 c는 null이 아님이 보장된다
    println(c.length)

}

fun failFast(message: String): Nothing { //코틀린에서 throw를 반환하게 되면 Noting을 반환하게 된다.
    throw IllegalArgumentException(message)
}