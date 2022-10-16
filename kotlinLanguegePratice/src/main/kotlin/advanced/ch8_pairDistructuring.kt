package advanced

//f((1,3)) = 1 + 3 = 4
//함수에 하나의 인자로 들어온 것을 튜플이라고 한다
/*
data class Tuple(val a: Int, val b: Int)

fun plus(tuple: Tuple) = tuple.a + tuple.b
 */
fun plus(pair: Pair<Int, Int>) = pair.first + pair.second
fun main() {
    //val plus = plus(Tuple(1, 3))
    val plus = plus(Pair(1, 3))
    println(plus)

    val pair = Pair("A", 1)
    //pair.first = "B" //컴파일 오류 -> first,second 가 val로 되어있기 때문에
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2() //두번쨰 컴포넌트 접근//pair.second와 같다
    println(second)

    val list = newPair.toList() //리스트로 변환 //immutable 리스트이다
    println(list)

    val triple = Triple("A", "B", "C") //3개의 요소를 가진 집합
    println(triple)
    triple.first
    triple.second
    //triple.third = "D"
    val newTriple = triple.copy(third = "D")
    println(newTriple)
    println(newTriple.component3())

    //4개 이상부터는 자료구조를 새로 만들어야한다
    val (a: String, b: String, c) = newTriple //구조분해 할당을 사용해서 값을 분해해서 초기화 할 수 있다.
    //타입까지 명시적으로 지정해서 해줄 수 도 있다.
    println("$a, $b, $c")

    val list3 = newTriple.toList()
    val (a1, a2, a3) = list3 //list도 componentN 함수가 있고, 총 5개의 ComponentN 함수가 있다.
    println("$a1, $a2, $a3")
    list3.component1()
    list3.component2()
    list3.component3()
    //list3.component4()
    //list3.component5()



    //val map = mutableMapOf("이상훈" to "개발자")
    val map = mutableMapOf(Pair("이상훈", "개발자"))
    for ((key, value) in map) {
        println("${key}의 작업은 $value")
    }
}