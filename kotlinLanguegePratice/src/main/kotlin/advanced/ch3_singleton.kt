package advanced

import java.time.LocalDate
import java.time.LocalDateTime

/*
//객체 선언을 통해 싱글톤 선언
object Singleton {
    val a = 1234
    fun printA() = println(a)
}

fun main(){
    println(Singleton.a)
    Singleton.printA()
}
 */
/*
object DateTimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD" //상수를 표기할 때, const 키워드를 사용한다.

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

fun main() {
    println(DateTimeUtils.now)
    println(DateTimeUtils.now)
    println(DateTimeUtils.now)
    println(DateTimeUtils.DEFAULT_FORMAT)
    val now = LocalDateTime.now()
    println(DateTimeUtils.same(now, now))
}
 */
//동반 객체
class MyClass {
    private constructor() //생성자를 직접 호출 못하도록 한다.

    companion object MyCompanion{
        val a = 1234
        fun newInstance() = MyClass()
    }
}

fun main() {
    println(MyClass.a)
    println(MyClass.newInstance())

    println(MyClass.MyCompanion.a) //Companion 이름을 붙여서 사용할 수 있다
    println(MyClass.MyCompanion.newInstance())
}

