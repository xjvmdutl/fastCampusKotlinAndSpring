package gettersetter

fun main() {
    //자바 스타일 //IntelliJ에서도 경고 표기
    val person = Person()
    person.setName("토니스타크")
    person.setAge(44)
    person.setAddress("스타크타워")

    println(person.getName())
    println(person.getAge())

    //코틀린 스타일  => 프로퍼티처럼 사용해라
    val person2 = Person()
    person2.name = "토니스타크"
    person2.age = 44
    println(person2.name)
    println(person2.age)

    //프로퍼티가 없음에도 게터 메서드라면 프로퍼티처럼 사용 가능하다
    println(person.uuid) //메서드 시작이 get으로 시작하기 때문에 코틀린에서 프로퍼티처럼 사용가능

    //세터가 있음에도 컴파일 오류 발생
    //person2.address = "" //setter가 있지만, getter가 없으므로 코틀린 컴파일러가 만들어 주지 않는다

    //address를 가져오는 메서드를 게터가 아닌 my로 했기 때문에 세터도 생성되지 않는다
    person2.myAddress() //메서드를 직접 호출하는 방법밖에 없다.
}