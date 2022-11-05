package extensions

fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z')) //원래 있던 함수처럼 사용 가능하다
}