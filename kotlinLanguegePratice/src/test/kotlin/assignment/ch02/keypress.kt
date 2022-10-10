import kotlin.math.abs

const val STAR = 10 //*
const val NUMBER_SIGN = 12 //#
fun solution(numbers: IntArray, hand: String): String {
    val answer = StringBuilder()
    var leftFinger = STAR
    var rightFinger = NUMBER_SIGN
    for (number in numbers) {
        when (number) {
            1, 4, 7 -> {
                leftFinger = goToLeftFinger(number, answer)
            }
            3, 6, 9 -> {
                rightFinger = goToRightFinger(number, answer)
            }
            2, 5, 8, 0 -> {
                val now = if (number == 0) 11 else number
                val leftFingerToNumberLength = getDistance(leftFinger, now)
                val rightFingerToNumberLength = getDistance(rightFinger, now)
                if (leftFingerToNumberLength < rightFingerToNumberLength) {
                    leftFinger = goToLeftFinger(now, answer)
                } else if (leftFingerToNumberLength > rightFingerToNumberLength) {
                    rightFinger = goToRightFinger(now, answer)
                } else {
                    when (hand) {
                        "right" -> rightFinger = goToRightFinger(now, answer)
                        "left" -> leftFinger = goToLeftFinger(now, answer)
                    }
                }
            }
        }
    }
    return answer.toString()
}

private fun getDistance(source: Int, destination: Int) =
    abs(((source - 1) % 3) - ((destination - 1) % 3)) + abs(((source - 1) / 3) - ((destination - 1) / 3))

private fun goToLeftFinger(
    number: Int,
    answer: StringBuilder
): Int {
    answer.append("L")
    return number
}

private fun goToRightFinger(
    number: Int,
    answer: StringBuilder
): Int {
    answer.append("R")
    return number
}

fun main() {
    println(solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
    println(solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left"))
    println(solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right"))
    println(solution(intArrayOf(2, 6, 8, 0), "left"))

}