package exception

import com.fastcampus.kotlinjavaspring.exception.JavaThrow
import java.io.IOException

class KotlinThrow {

    @Throws(IOException::class) //강제로 예외 전파를 하고 싶을 때 사용
    fun throwIOException() {
        throw IOException("체크드 익셉션인 IOException 발생")
    }
}

fun main() {
    //예외를 전파하거나, try-catch를 사용하지 않아도 된다(강제하지 않는다)
    val javaThrow = JavaThrow()
    javaThrow.throwIOException()

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIOException()

}