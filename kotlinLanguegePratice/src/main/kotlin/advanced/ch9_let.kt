package advanced

fun main() {
    val str: String? = "안녕"

    val result: Int? = str?.let {
        println(it)
        /*
        val abc: String? = "abc"
        abc?.let {
            val def: String? = "def"
            //함수 내부에 함수가 매번 쓰이니, 가독성 측면에서 그렇게 좋지는 않다.ㄴ
            def?.let {
                println("abcdef가 null 아님")
            }
        }
         */
        val abc: String? = "abc"
        val def: String? = "def"
        //많이 중첩되는 경우는 이전의 If/else 를 쓰는것이 좋다
        if (!abc.isNullOrBlank() && !def.isNullOrBlank()) {
            println("abcdef가 null 아님")
        }
        1234 //return 키워드는 없지만, 마지막 쓴 값이 리턴이 된다.
    }
    println(result)

    /*
    val this:String? = null //this는 키워드라 다른 곳에서 사용 안된다.
    val it: String? =null //it은 사용가능 //소프트 예약어
     */
    val hello = "hello"
    val hi = "hi"
    /*
    hello.let {
        println(it.length)
        hi.let {
            println(it.length)//해당 it는 해당 컨텍스트 it인지, 외부의 it인지 알기 힘드므로, 중첩된 코드는 사용하지 말자
        }
    }
     */
    hello.let { a: String ->
        println(a.length)
        hi.let {b: String -> //변수를 사용하는 방식으로 하여, 혼동이 없도록 하자
            println(b.length)
        }
    }
}