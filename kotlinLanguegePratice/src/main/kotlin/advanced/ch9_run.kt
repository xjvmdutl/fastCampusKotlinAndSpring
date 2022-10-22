package advanced

//Run : 수신 객체의 프로퍼티를 구성하거나,새로운 결과를 반환하고 싶을 때 사용
class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    //DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean{
        println("DB 접속 중...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}
fun main() {
    /*
    val config = DatabaseClient()
    config.url = "localhost:3306"
    config.username = "mysql"
    config.password = "1234"
    val connected = config.connect()
    println(connected)
     */
    /*
    //let으로 변환도 가능
    val connected: Boolean = DatabaseClient().let {
        it.url = "localhost:3306"
        it.username = "mysql"
        it.password = "1234"
        it.connect()
    }

     */

    val connected: Boolean = DatabaseClient().run {
        //변수의 참조를 매번 사용할 필요 없이, 사용할 수 있다.
        url = "localhost:3306" //수신자 객체가 DatabaseClient 이기 때문에 this 생략 가능
        username = "mysql"
        password = "1234"
        connect()
    }
    println(connected)
}