package iteratorpattern

data class Car(val brand: String)

//Iterable를 구현해 Aggregate를 구현한다,
class CarIterable(val cars: List<Car> = listOf()) : Iterable<Car> {
    override fun iterator(): Iterator<Car> = CarIterator(cars)
}

class CarIterator(val cars: List<Car> = listOf(), var index: Int = 0) : Iterator<Car> {
    override fun hasNext(): Boolean {
        return cars.size > index
    }

    override fun next(): Car {
        return cars[index++] //next를 호출할 때마다, index를 증가
    }
}

fun main() {
    val carIterable = CarIterable(listOf(Car("람보르기니"), Car("페라리")))
    val iterator = carIterable.iterator()
    //Iterator 패턴은 데이터를 저장하는 곳에서 사용하는 곳에 주는 poll 기반, Observer 패턴은 push 기반이다.
    while (iterator.hasNext()) {
        println("브랜드 : ${iterator.next()}")
    }
}

