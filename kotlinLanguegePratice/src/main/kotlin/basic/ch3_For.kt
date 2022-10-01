package basic

fun main() {
    //범위 연산자 .. 를 사용해 for loop 돌리기
    for (i in 0..3) { //범위 연산자를 사용해 쉽게 출력가능(가장 마지막 숫자도 포함된다)
        println(i)
    }

    // until을 사용해 반복한다.
    // 뒤에 온 숫자는 포함하지 않는다.
    for (i in 0 until 3) { //뒤에 숫자 포함 x
        println(i)
    }

    //step 에 들어온 값 만큼 증가시킨다
    for (i in 0..6 step 2) { //값이 step만큼 증가
        println(i)
    }

    //downTo를 사용해 반복하면서 값을 감소시킨다
    for (i in 3 downTo 1) { //값이 downTo 만큼 감소된다
        println(i)
    }

    //전달받은 배열을 반복
    val numbers = arrayOf(1, 2, 3)

    for (i in numbers) {
        println(i)
    }
}