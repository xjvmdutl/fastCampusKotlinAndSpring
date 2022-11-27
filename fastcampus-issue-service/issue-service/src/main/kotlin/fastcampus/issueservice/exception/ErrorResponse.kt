package fastcampus.issueservice.exception

data class ErrorResponse(
    val code: Int, // 어떤 오류가 발생했는지 알 수 있는 코드, 커스텀한 코드를 통해 어떤 오류가 발생한지 파악
    val message: String,
) {

}