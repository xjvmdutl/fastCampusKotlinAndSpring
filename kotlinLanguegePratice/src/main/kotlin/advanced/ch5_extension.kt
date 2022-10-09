package advanced

fun String.first(): Char { //확장대상.메서드명, 확장대상.변수명 을 써서 확장함수를 작성할 수 있다.
    //확장함수는 항상 자바코드로 변환하면, 자기 자신을 첫번쨰 인자로 받는다.
    return this[0] //함장함수 내부에서 쓰이는 this 를 리시버, 수신자 객체라 부른다.
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

class MyExample{
    fun printMessage() = println("클래스 출력")
}

//fun MyExample.printMessage() = println("확장 출력") //기존에 존재하는 메서드를 확장함수로 정의한다면?
fun MyExample.printMessage(message: String) = println(message) //인자가 다르면 잘 동작한다(시그니처가 다르기 떄문)

fun MyExample?.printNullOrNotNull(){
    if(this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {
    //println("ABCD".first()) //A
    //println("ABCD".addFirst('Z')) //ZABCD
    /*
    MyExample().printMessage() //클래스가 직접 보유하는 맴버 클래스의 메서드가 우선 순위가 높다.
    //코틀린 버젼이 올라가면서, 기존 클래스에 존재하는 메서드의 시그니처가 바뀌어 예상치 못한 오류를 발생시킬 수도 있으므로 이를 인지하고 사용하
    MyExample().printMessage("확장 출력")
     */
    var myExample: MyExample? = null
    myExample.printNullOrNotNull() //null 안전 연산자를 쓰지 않았는데도 컴파일 오류가 안났다 -> 내부에서 null 처리코드가 구현되어 있기 때문에 컴파일 오류가 발생하지 않는다

    myExample = MyExample()
    myExample.printNullOrNotNull()
}