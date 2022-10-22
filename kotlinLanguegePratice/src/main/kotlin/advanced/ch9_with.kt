package advanced

fun main() {
    val str = "안녕하세요"
    val length = with(str) {
        //println("length= $length")
        length //함수의 마지막에 쓴 결과를 반환 한다
    }
    println(length)

    //with는 확장함수가 아니다 -> 파라미터에 참조를 넣는다
    val result:Boolean = with(DatabaseClient()) {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }
    println(result)
}