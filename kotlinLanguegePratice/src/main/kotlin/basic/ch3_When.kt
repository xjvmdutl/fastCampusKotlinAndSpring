package basic

fun main() {
    //자바 코드를 코틀린의 when 식으로 변환한 코드(자바 최신 switch 문은 식을 반환하기도 한다)
    //자바 코드에서는 break를 작성하지 않으면, 코드가 밑으로 흘러간다.
    val day =  2
    val result = when (day) { //when식을 할당할 수 있다.
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }
    println(result)

    //else를 생략할 수 있다.
    when(getColor()){
        //들어올 수 있는 값을 코틀린이 추론할 수 있기 때문에 else를 생략할 수 있다
        Color.RED -> println("red")
        Color.GREEN -> println("green")
    }
    //여러개의 조건을 콤마로 구분해 한줄에서 정의할 수 있다.
    when(getNumber()){
        0, 1 -> print("0 또는 1")
        else -> print("0 또는 1이 아님")
    }

}

enum class Color{
    //두가지 값만 반환할 수 있다.
    RED, GREEN
}

fun getColor() = Color.RED

fun getNumber() = 2