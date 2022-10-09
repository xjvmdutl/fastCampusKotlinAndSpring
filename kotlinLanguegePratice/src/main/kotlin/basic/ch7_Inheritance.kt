package basic

//코틀린 모든 클래스의 조상은 Any이다(equals, hashCode, toString 을 상속받는다)
//코틀린의 모든 클래스는 기본적으로 final이므로, 상속을 막는다 -> open 키워드를 통해 상속이 가능하도록 할 수 있다.
//open class Dog //open 키워드가 있으므로 상속 가능
open class Dog {
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

open class Bulldog(final override var age: Int = 0) : Dog() { //기본 생성자를 통해서도 재정의를 할 수 있다.
    //override var age: Int = 0 //오버라이드 키워드를 통해 하위 클래스에서 상위클래스 메서드를 오버라이드 할 수 있다.

    final override fun bark() { //하위 클래스에서 더이상 override한 메서드를 재정의 못하도록 박기 위해서는 Final 키워드를 사용하면 된다
        //println("컹컹")
        super.bark() //상위 클래스의 함수나, 프로퍼티를 재사용하기 위해서는 super 키워드를 사용하면 된다.
    }
}

class ChildBulldog : Bulldog() {
    /*
    override var age: Int = 0
    override fun bark() {
        super.bark()
    }
    */
}

abstract class Developer { //추상 클래스를 만들고 싶으면 abstract 키워드를 사용하자
    abstract var age: Int
    abstract fun code(language: String)
}

//abstract 클래스의 메서드나, 프로퍼티를 재정의를 반드시 해주어야한다
class BackendDeveloper(override var age: Int = 0) : Developer() {
    override fun code(language: String) {
        println("I code with $language")
    }
}

fun main() {
    /*
    val dog = Bulldog(age = 2)
    println(dog.age)
    dog.bark()
     */
    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")

}