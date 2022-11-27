package fastcampus.issueservice.domain.enums

enum class IssueType {
    BUG, TASK;

    companion object {
        //fun of(type: String) = valueOf(type.uppercase())
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}

/*
fun main() {
    val type = IssueType("BUG") //생성자를 사용한거 처럼 쓸수 있다.
}
 */