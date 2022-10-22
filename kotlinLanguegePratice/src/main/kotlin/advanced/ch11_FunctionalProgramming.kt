package advanced

fun main() {
    /*
    //코틀린에서 제공하는 함수형 프로그래밍
    val list = mutableListOf(printHello) //리스트에 값으로 함수를 넣을 수 있다.
    //list[0]() //함수를 실행할 때는 함수 실행 표기법인 ()를 반드시 써야한다
    val func: () -> Unit = list[0]
    func()
     */
    //call(printHello)


    //컴파일 오류: fun으로 선언한 객체는 일급 객체의 특성을 가지지 않기 때문에 데이터 구조에 넣거나, 함수 인자로 전달할 수 없다
    /*
    val func = printNo
    val list = mutableListOf(printNo)
    call(printNo)
     */
    /*
    val result = plus(1, 3, 5)
    println(result)
     */
    /*
    val list = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }
    //forEachStr(list, printStr)

    list.forEach(printStr) //list에서 제공하는 forEach도 고차함수이다.
    val upperCase: (String) -> String = {
        it.uppercase()
    }
    println(list.map(upperCase))
     */
    /*
    outerFunc()() //익명 함수를 실행하기 위해서는 함수 표현식을 2번 써야한다.
    val func = outerFunc()
    func()
     */
    //후행 람다 전달 : 함수 전달 인자가 하나이거나, 파라미터가 가장 뒤에 있는경우, 함수를 호출하면서, 람다식을 구현체로 전달 할 수 있다.
    /*
    val list = listOf("a", "b", "c")
    forEachStr(list) {
        println(it)
    }

    arg1 {
        it.length
        it.first()
    }
    arg2 { a: String, b: String ->
        //it 키워드 사용 안된다
        a.length
        b.first()
    }
     */
    //val callReference: () -> Unit = { printHello() }
    val callReference = ::printHello //람다 레퍼런스 구문을 사용
    callReference()()

    val numberList = listOf("1", "2", "3")
    //numberList.map { it.toInt() }.forEach { println(it) }
    numberList.map(String::toInt).forEach(::println) //람다 페퍼런스를 사용해 쉽게 표현가능
    //탑레벨 함수일 경우 람다 레퍼런스 앞에 아무것도 없이 사용하면 되고, 확장함수나,클래스 맴버 함수일 경우 람다 레퍼런스 앞에 클래스 이름을 쓰면 된다.

    //코틀린에서는 애로우라는 함수형 라이브러리를 적용한다면, 쉽게 함수형 프로그래밍을 작성할 수 있다.
}

val func: () -> Unit = {} //함수도 타입이라 이와 변수를 선언하듯이 선언 가능하다

//코틀린에서 함수는 일급 객체로, 변수에 대입할 수 있고, 데이터 구조에 저장할 수 있다.
val printHello: () -> Unit = { println("Hello") }

//함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block() //call 함수 내부에서, 인자로 받은 함수를 실행할 수 있다.
}

fun printNo() = println("No!")

val printMessage: (String) -> Unit = { message: String -> println(message) }
//val printMessage2: (String) -> Unit = { message -> println(message) } //message 타입 추론 가능,
//val printMessage3: (String) -> Unit = { println(it) } //message 참조를 it와 같은 내부 참조로 변경 가능

//다수의 인자를 받아 처리하는 함수
//val plus: (Int, Int) -> Int = { a, b -> a + b }
val plus: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    //함수를 인자로 받아 내부적으로 함수를 실행하는것을 고차함수라고 한다
    for (item in collection) {
        action(item)
        //println(item) //현재는 이 동작과 동일하다
    }
}


/*
fun outerFunc(): () -> Unit {
    return fun() { //이름 없는 익명 함수를 반환했다
        println("이것은 익명함수!")
    }
}
 */
/*
fun outerFunc(): () -> Unit {
    return { //람다식 변경
        println("이것은 익명함수!")
    }
}
 */
fun outerFunc(): () -> Unit = { println("이것은 익명함수!") } //람다 함수를 생략해서 구현

//람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//최대한 생략한 람다 식
val sum2 = { x: Int, y: Int -> x + y } //가독성을 판별해서, 적절하게 선택해서 사용하자

fun arg1(block: (String) -> Unit) {}
fun arg2(block: (String, String) -> Unit) {}