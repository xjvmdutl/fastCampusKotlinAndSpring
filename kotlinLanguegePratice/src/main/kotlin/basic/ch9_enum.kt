package basic

enum class PaymentStatus(val label: String) : Payable { //enum 클래스 선언
    //enum 클래스도 클래스로 생성자를 만들수 있다
    UNPAID("미지급") {
        override fun isPayable(): Boolean {
            return true
        }
    },
    PAID("지급완료") {
        override fun isPayable(): Boolean = false
    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean = false
    };

    //abstract fun isPayable(): Boolean
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    //println(PaymentStatus.UNPAID.label)
    /*
    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }
     */
    /*
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    for (status in PaymentStatus.values()) {
        println("[$status](${status.label})")
    }
     */
    for (status in PaymentStatus.values()) {
        println("[$status](${status.label}) : ${status.ordinal}") //ordinal은 프로퍼티선언 순서
    }
}