package basic

var x = 5 //함수 외부에서, 변수 선언이 가능하다.
//탑레벨 변수를 제공하기 때문에 클래스를 생성하지 않아도 쉽게 변수 선언이 가능하다.

fun main(){
    x += 1
    println(x)


    val a: Int = 1 //타입 지정
    val b = 1 //타입 생략(타입 추론 사용)

    val c: Int
    c = 3 //지연 할당(변수를 선언 후, 대입)

    /*
    val d  //타입을 선언 하지 않고 대입시 컴파일 오류
    d = 123
     */

    // val(value)   : 자바의 final 키워드와 같이 한번 대입후 값 변경이 불가능하다
    // var(variable): 값 대입 후에, 새로운 값 대입이 가능하다.

    //val e: String = "Hello"//값을 재할당 하게 되면 오류가 발생한다 -> val 키워드가 붙어 있기 때문
    var e : String = "Hello"
    e = "World"

    var f = 123 //타입이 int로 추론되었다가 string으로 변경 시키려면 오류가 난다.
    //f = "hi"

}