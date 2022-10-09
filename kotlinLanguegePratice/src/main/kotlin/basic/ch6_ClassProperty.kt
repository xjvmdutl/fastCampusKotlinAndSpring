package basic

/*
class Coffee constructor(val name: String) { //constructor 키워드를 생략할 수 있다.

}
 */
class Coffee(
    var name: String = "",
    var price: Int = 0, //후행 쉼표가 가능하다, price를 수정하지 않고 새로운 필드를 추가할 수 있다.
    //코드 리뷰 시 변경사항이 한부분만 변경된 것을 명시적으로 알 수 있다
    //val brand: String,
    var iced:Boolean = false,
){
    val brand: String
        //get() = "스타벅스" //커스텀 getter
        get() {
            return "스타벅스"
        }

    var quantity: Int = 0
        set(value) { //커스텀 setter
            if (value > 0 ){ //수량이 0 이상인 경우에만 할당
                field = value //식별자로, getter/setter에 대해서 field를 제공한다.
                //quantity = value //프로퍼티 값을 직접 세팅해 주면 내부적으로 계속 setter를 호출하기 떄문에 stackoverflow 에러가 발생한다.
            }
        }
}

class EmptyClass //본문이 없는 클래스

fun main() {
    val coffee = Coffee()
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000 //실제로는 setter를 사용해 값을 세팅해 준다, 코틀린 컴파일러가 getter/setter를 알아서 생성해준다.
    coffee.quantity = 1
    coffee.iced = true

    if (coffee.iced){ //클래스의 상태를 프로퍼티로 가지고 온다.
        println("아이스 커피")
    }
    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")
}