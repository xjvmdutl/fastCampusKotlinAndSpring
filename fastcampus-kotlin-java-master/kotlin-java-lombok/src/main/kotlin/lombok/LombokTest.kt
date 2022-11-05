package lombok

fun main() {
    val hero = Hero()
    /*
    //롬복이 만들어준 getter/setter가 동작이 안된다.
    //코틀린 컴파일러가 컴파일이후 어노테이션 프로세싱이 동작하기 떄문에 사용시 오류가 발생하는 것이다.
    //해결하는 방법으로는 1. 롬복을 제거 후, idea의 getter/setter 생성기능을 사용하는 것이다.
    hero.name = "아이언맨"
    println(hero.name)
    //2. 코틀린으로 마이그레이션
     */
    /*
    hero.address = "스타크타워"
    println(hero.address)
    hero.name = "아이언맨"
    println(hero.name)
     */
    val heroKt = HeroKt(name = "아이언맨", age = 50, address = "스타크타워")
    println(heroKt)
}