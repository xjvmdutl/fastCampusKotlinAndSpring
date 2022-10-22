package advanced

//alse : 부수 작업을 수행하거나, 전달받은 객체를 그대로 반환할 때 사용한다
class User(val name: String, val password: String) {
    fun validate(){
        if(name.isNotEmpty() && password.isNotEmpty()){
            println("검증 성공")
        }else{
            println("검증 실패!")
        }
    }
    fun printName() = println(name)
}

fun main() {
    val user: User = User(name = "tony", password = "1234")
    user.validate()
    User(name = "tony", password = "1234").also {
        it.validate()
        it.printName()
    }
}