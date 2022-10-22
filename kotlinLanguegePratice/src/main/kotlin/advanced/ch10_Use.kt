package advanced

import java.io.FileWriter

fun main() {
    FileWriter("test.txt")
        .use {
            //use 내부적으로 finally 안에 close가 호출되도록 되어있다.
            it.write("Hello Kotlin")
        }
}