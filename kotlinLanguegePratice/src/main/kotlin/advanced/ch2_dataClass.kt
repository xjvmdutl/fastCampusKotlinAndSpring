package advanced

//데이터를 보관하거나, 전달하는 목적을 가진 객체를 만들 때 사용한다.
//equals, hashCode, toString, componentN, copy 함수를 자동으로 만들어 준다.
//주로 자바에서는 lombok을 쓰거나 15에서는 record를 사용한다.
//디컴파일 = tools-> kotlin -> kotlin Bytecode
data class Person(val name: String, val age: Int){
}

fun main() {
    val person1 = Person(name = "tony", age = 12)
    //val person2 = Person(name = "tony", age = 12)
    //println(person1 == person2) //일반적인 클래스일 경우 false, data 클래스일 경우 true

    val set = hashSetOf(person1)
    println(set.contains(person1)) //hashCode 까지 재정의 해야 hash를 사용하는 곳에서도 true가 나온다.
    //println(person1.toString()) //data 클래스가 아닐경우 주소값이 출력된다, data를 사용하면, 프로퍼티 값이 출력

    /*
    person1.name = "strange"
    println(set.contains(person1)) //false가 출력된다. 값이 변경되어 이를 equals/hashcode 가 동작해서 false를 반환한다.
     */
    //이러한 문제 때문에 불변객체를 만들어서 복사해서 사용하는 것이 좋다.
    /*
    val person2 = person1.copy(name = "strange")
    println(person2)
     */
    //println("이름=${person1.component1()}, 나이=${person1.component2()}") //프로퍼티를 가지고 온것과 동일하게 component를 사용해서 가지고 올 수 있다.
    //더 쉽게 구조분해 할당을 사용해도 된다
    val (name, age) = person1
    println("이름=${name}, 나이=${age}")
}

