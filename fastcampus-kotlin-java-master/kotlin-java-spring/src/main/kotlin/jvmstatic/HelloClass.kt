package jvmstatic

class HelloClass {
    //동반 객체
    companion object {
        @JvmStatic
        fun hello() = "hello!"
    }
}

//싱글톤 객체
object HiObject {
    @JvmStatic
    fun hi() = "hi!"
}

fun main() {
    val hello = HelloClass.hello()
    val hi = HiObject.hi()

}