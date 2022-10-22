package advanced

fun main() {
    //apply 같은 경우 마지막에 호출한 함수가 아닌 본인을 반환한다
    /*
    val client = DatabaseClient().apply {
        //초기화나 같은 동작에서 많이 사용한다
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }
    //println(client)
    client.connect().run {
        println(this)
    }
     */
    DatabaseClient().apply {
        //초기화나 같은 동작에서 많이 사용한다
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }.connect()
        .run { println(this) }
}