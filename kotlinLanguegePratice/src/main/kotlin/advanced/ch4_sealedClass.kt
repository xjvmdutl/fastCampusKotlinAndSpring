package advanced

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용합니다.")
    }
}

object OtherDeveloper: Developer(){
    override val name: String = "익명"
    override fun code(language: String) {
        TODO("Not yet implemented")
    }
}

data class AndroidDeveloper(override val name: String): Developer(){
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다 ${language}를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()
    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        //else 구문이 없게 되면, 컴파일 오류가 발생한다
        //컴파일러가 Developer 를 구현한 것이 2가지 밖에 없다는 것을 알 수가 없기 떄문에 -> sealed 사용
        //sealed 클래스는 컴파일러가 컴파일 시점에, 하위 클래스가 2가지 타입만 있다는 것을 알고 컴파일 오류가 나지 않도록 한다.
        //sealed 클래스의 제약은 같은 패키지, 같은 모듈에 있어야지만, 컴파일러가 파악할 수 있다.
        //is OtherDeveloper -> pool[developer.name] = developer //새로운 클래스를 추가하게 되면, 이 코드가 없으면 컴파일 오류가 난다.
        //else -> println("지원하지 않는 개발자 종류입니다.") //Android 개발자를 추가하면, 여기서 같이 걸리게 된다 -> 개발자는 OtherDeveloper만 걸리면 좋겠다고 생각했음
        is AndroidDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> pool[developer.name] = developer
    }
    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "카즈야")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDeveloper(name = "토마스")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
    println(DeveloperPool.get("토마스"))
}
