package basic

//기본적인 함수 선언 스타일
fun sum(a: Int, b: Int): Int {
    return a + b;
}

//표현식 스타일
fun sum2(a: Int, b: Int): Int = a + b //로직 없이 표현식이 들어간다

//표현식 & 반환타입 생략
fun sum3(a: Int, b: Int) = a + b //반환 타입도 생략할 수 있다(컴파일러가 반환타입을 추론)

//몸통이 있는 함수는 반환 타입을 제거하면 컴파일 오류
fun sum4(a: Int, b: Int) : Int {
    return a + b //반환 타입을 제거하면 오류가 발생하게 된다.
}

//반환타입이 없는 함수는 Unit을 반환한다.
fun printSum(a: Int, b: Int): Unit{ //아무 타입도 반환하지 않으면, Unit을 반환하고 생략이 가능하다.
    println("$a + $b = ${a+ b}")
}

//디폴트 파라미터
fun greeting(message: String = "안녕하세요!!"){
    //자바는 디폴트 파라미터가 없기 때문에 값이 없을 경우, 값을 대입해 줘야하는 로직을 따로 작성해 주어야 한다.
    println(message)
}
/*
fun main(){
    greeting()
    greeting("HI!!!")
}
 */

//네임드 아규먼트
//파라미터 이름과 값을 매핑하는 기법
fun log(level: String = "INFO", message: String){
    println("[$level]$message")
}
fun main(){
    //파라미터 이름으로 값을 전달 해 줄 수 있다.
    log(message = "인포 로그")
    log(level = "DEBUG", "디버그 로그")
    log("WARN", "워닝 로그")
    log(level = "ERROR", message = "에러 로그")
}