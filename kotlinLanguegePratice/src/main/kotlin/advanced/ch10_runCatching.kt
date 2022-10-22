package advanced

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {
    /*
    val result = try {
        getStr()//항상 예외 발생
    } catch (e: Exception) {
        println(e.message)
        "기본값"
    }
    println(result)
     */
    //runCatching을 사용하면, try-catch문을 더욱 우아하게 작성할 수 있다.
    /*
    val result = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }
     */
    /*
    val result = runCatching { getStr() }
        //.getOrNull() //성공 = 값, 실패(예외) = null 반환
        //.exceptionOrNull() //성골 = null, 실패 = 예외 반환
        //.getOrDefault("기본 값") //성공 = 값, 실패 = 디폴트값 반환
        .getOrElse { //성공 = 값, 실패시, it로 예외를 받아 함수의 결과를 반환한다.
            println(it.message)
            "기본 값"
        }
     */
    /*
    val result = runCatching { "안녕" }
        //.getOrThrow() //성공 = 값, 실패 = 예외
        .map { //Success로 감싸진 값에 새로운 값을 넣을 수가 있다
            "${it}하세요"
        }.getOrThrow()
     */
    val result = runCatching { "안녕" }
        /*
        .map {
            throw Exception("예외")
        }.getOrDefault("기본값") //map 안에서 발생한 예외는 getOrDefault 로 복구하려구 해도 안된다.
         */
        /*
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("기본 값")
         */
        /*
        .recover { "복구" } //성공시에 동작하지 않고, 실패할 경우 recover가 동작한다.
        .getOrNull()
         */
        .recoverCatching {
            throw Exception("예와")
        }.getOrDefault("기본 값")
    /*
    result?.let {
        println(it.message)
        throw it
     */
    println(result)
}