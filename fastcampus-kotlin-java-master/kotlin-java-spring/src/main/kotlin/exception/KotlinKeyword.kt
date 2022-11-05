package exception

import com.fastcampus.kotlinjavaspring.exception.JavaKeyword

enum class CountryCodeKotlin {
    kr, jp, us, `do`; //코틀린에서는 백틱(`)을 사용하면 문제가 발생하지 않기 때문에 비지니스적으로 의미있는 이름을 쓸 수 있다
}


fun main() {
    val javaKeyword = JavaKeyword()

    javaKeyword.`in` //in은 코틀린에서 사용되는 예약어라 문제가 발생하지만, 백틱(`)을 사용하면 이를 해결 할 수있다

    javaKeyword.`is`
}