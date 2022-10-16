package advanced

class MyGenerics<out T>(val t: T){

}

class Bag<T>{
    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ){
        to.addAll(from)
    }
}

fun main() {
    //제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트를 제공
    //val generics = MyGenerics<String>("테스트")
    //val generics = MyGenerics("테스트") // 컴파일러가 제네릭 타입이 String 인것을 알기 때문에 생략 가능

    /*
    //변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    //타입아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    //스타 프로젝션을 사용
    val list3: List<*> = listOf<String>("테스트")
    val list4: List<*> = listOf<Int>(1,2,3,4)
     */

    //변성 : 제네릭에서 파라미터화된 타입이 어떤 관계가 있는지를 설명하는것
    //PECS : (Producer-Extends, Consumer-Super)
    //공변성은 자바 제네릭의 extends, 코틀린에서는 out
    //반공변성은 자바 제네릭의 super, 코틀린에서 in

    val generics = MyGenerics<String>("테스트")
    //MyGeneric<String> 이 MyGeneric<CharSequence> 보다 상위 타입으로 공변성을 사용하여 구현할 수 있다
    val charGenerics: MyGenerics<CharSequence> = generics //컴파일 오류 발생

    val bag = Bag<String>()
    //반공변성 사용 : 제네릭을 소비하는 측이 되므로 반공변성이다(Consumer)
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4")) //컴파일 오류

    //무공변성 : 실제 String은 CharSequence는 계층 구조이지만, 이걸 제네릭화한 mutableList<String>과 mutableList<CharSequence>는 아무 관계가 아닌것
}