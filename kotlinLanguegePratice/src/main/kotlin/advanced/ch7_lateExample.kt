package advanced

class ch7_lateExample {

    lateinit var text: String //가변 프로퍼티의 지연 로딩
    //불변으로 만들면 컴파일 오류가 발생한다.//nullable(?)하게 선언해도 컴파일 오류가 발생한다.

    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        /*
        if (this::text.isInitialized) { //단, 이함수는 클래스 외부에서 사용이 안된다.
            println("초기화됨")
        } else {
            text = "안녕하세요" // 지연 초기화
        }
        text = "안녕하세요"
         */
        println(text) //출력을 먼저 하고 초기화 하면 예외 발생(컴파일 오류가 발생하지 않고 런타임 오류가 발생
    }
}

fun main() {
    val test = `ch7_lateExample`()
    //test.printText()
    //test.printText()

    /*
    test.text="하이요"
    //test.text.isInitialized //존재하지 않는다
    test.printText()
     */
    if(!test.textInitialized){
        test.text = "하이요"
    }
    test.printText()
}