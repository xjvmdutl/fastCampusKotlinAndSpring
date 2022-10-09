package basic

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart : Wheel {
    //인터페이스 키워드를 사용해 인터페이스를 정의할 수 있으며, 인터페이스 내부에 구현해야할 함수나, default와 같이 구현이 되어있는 함수 모두 정의할 수  있다.

    val coin: Int //인터페이스에서 프로퍼티 선언도 할 수 있다.

    val weight: String
        get() {
            //인터페이스는 내부에서 백킹 필드를 사용할 수 없다.
            return "20kg"
        }

    fun add(product: Product)
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다.")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다.")
    }
    fun printId() = println("5678")
}

//두개의 인터페이스에서 동일한 디폴트 인터페이스를 제공하게 된다면, 하위 클래스에서 컴파일 오류가 발생한다(디폴트 함수의 재정의를 강제한다)
class MyCart(override val coin: Int) : Cart, Order { //복수개의 인터페이스 구현이 가능하다

    override fun add(product: Product) {
        if (coin <= 0)
            println("코인을 넣어주세요")
        else
            println("${product.name}이(가) 카트에 추가됐습니다.")

        //주문하기
        super<Order>.add(product)//복수개의 인터페이스에서 해당 키워드를 호출하기 위해서는 super 키워드를 통해 호출해야한다.
        //super<> 를 통해 상위 인터페이스에 접근 할 수 있다.
    }

    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}


fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}
