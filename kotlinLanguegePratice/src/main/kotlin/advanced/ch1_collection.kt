package advanced

import java.util.Collections
import java.util.LinkedList
import java.util.stream.Collectors

fun main() {
    // immutable
    val currencyList = listOf("달러", "유로", "원") //한번 생성하면, 쓰기/수정/삭제 할 수 없다

    //mutable
    /*
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")
     */
    val mutableCurrencyList = mutableListOf<String>().apply {
        //내부에 참조를 가지고 있어 좀 더 가독성있게 코드를 작성할 수 있다
        add("달러")
        add("유로")
        add("원")
    }

    //immutable set
    val numberSet = setOf(1, 2, 3, 4)

    //mutable Set
    val mutableNumberSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    //immutable map
    val numberMap = mapOf("one" to 1, "two" to 2) //중위 표현식

    //mutableMap
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap["two"] = 2
    mutableNumberMap["three"] = 3

    // 컬렉션 빌더
    // 컬렉션 빌더는 내부에선 mutable 반환은 immutable
    val numberList: List<Int> = buildList {
        //buildList 내부에서 add를 사용해 값을 넣고 있다(mutableList를 사용해 값을 넣었다는 의미) -> 반환 되는 리스트는 immutable 한 리스트로, 위에서 생성한 것과 차이가 있다.
        add(1)
        add(2)
        add(3)
    }

    //linkedList
    val linkedList = LinkedList<Int>().apply { //각 구현 리스트의 생성자를 통해 리스트를 생성할 수도 있다.
        addFirst(3)
        add(2)
        addLast(1)
    }

    //arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }
    /*

    //iterator
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("==================")

    //for 문
    for (currency in currencyList) {
        println(currency)
    }

    println("==================")

    currencyList.forEach { //인라인 함수
        println(it)
    }
     */

    //for loop -> map
    val lowerList = listOf("a", "b", "c")
    /*
    val upperList = mutableListOf<String>()
    for(lowerCase in lowerList){
        upperList.add(lowerCase.uppercase())
    }
     */
    val upperList =
        lowerList.map { it.uppercase() } //map, filter 와 같은 인라인 함수를 사용해 개발자가 직접 코드를 작성하지 않아도 된다
    //println(upperList)

    /*
    val filterList = mutableListOf<String>()
    for(upperCase in upperList){
        if(upperCase == "A" || upperCase == "C"){ // a, c 만 filter를 통해 값을 넣고 싶다
            filterList.add(upperCase)
        }
    }
     */

    //val filterList = upperList.filter { it == "A" || it == "C" }
    //java8 stream 과 인라인 함수의 차이 : 자바8 stream은 터미널 오퍼레이터로, 최종 연산자가 실행이 되어야지만, 실행이 되지만 코틀린은 바로 실행이 된다.
    //val filterList = upperList.stream().filter { it == "A" || it == "C" }.collect(Collectors.toList())
    /*
    val filterList = upperList
        .asSequence() //자바8의 stream()과 같은 역할을 한다고 보면된다.
        .filter { it == "A" || it == "C" }
        .toList() //최종적으로 toList가 실행이 되어야지 모든 연산이 실행이된다
    */
    //만약 대량의 데이터를 filter를 통해 만들게 된다면, 매번 인라인 함수를 사용할 떄마다 list를 만들기 떄문에 많은 리스트에 의해 OOM이 발생할 수도 있다.
    val filterList = upperList
        .asSequence()
        .filter { it == "A" || it == "C" }
        .filter { it == "A" }
        .filter { it == "A" }
        .filter { it == "A" }
        .filter { it == "A" }
        .toList()
    println(filterList)
}