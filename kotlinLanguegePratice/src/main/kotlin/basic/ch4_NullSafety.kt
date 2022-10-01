package basic

fun getNullStr(): String? = null
fun getLengthIfNotNull(str: String?) = str?.length ?: 0 //엘비스 연산자를 사용해 0 반환

fun main() {
    /*
    val a: String = null //컴파일 오류 (null을 받을 수 없는 타입이기 때문)
    var b: String = "aabbcc"
    b = null //컴파일 오류
     */
    /*
    var a: String? = null //nullable 한 타입
    //a.length //nullable 한 타입에 메서드를 쓰면 컴파일 오류

    println(a?.length)  //컴파일 오류 사라진다 //null 안전 연산자를 사용해 접근하게 되면 nullPoint 예외 없이 사용할 수 있다.

    val b: Int = if (a != null) a.length else 0
    println(b)
    //좀 더 간단한 널 처리가 가능하다.
    //엘비스 연산자
    val c = a?.length ?: 0 //엘비스 연산자를 사용해 간단한 처리가 가능하다(좌변이 널인 경우 우변 출력)
    println(c)
     */

    //자바 코드 Kotlin으로 변환
    val nullableStr = getNullStr()
    //val nullableStrLength = nullableStr.length //컴파일 오류가 발생한다
    val nullableStrLength =
        nullableStr?.length ?: "null인 경우 반환".length //엘비스 연산자를 통해 "null인 경우 반환".length 실행
    println(nullableStrLength)

    val length = getLengthIfNotNull(null)
    println(length)

    //코틀린에서도 NPE를 발생 시킬수 있다.
    //throw NullPointerException()

    val c: String? = null
    //단언 연산자는 null을 없애주는 것이 아니라, 개발자가 핸들링 하도록 하는것이기 때문에 NPE가 발생할 수 있다.
    val d = c!!.length //단언 연산자 : 개발자가 봤을때, null이 아님을 확신할 떄 사용하는 연산자
    //Java 와 상용운용 하게 되면서, null 참조가 된 코드를 코틀린에서 실행하게 되면, NPE가 발생할 수 있다
}