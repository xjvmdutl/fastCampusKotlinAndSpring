package assignment.ch01


val firstPerson = intArrayOf(1, 2, 3, 4, 5)
val secondPerson = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
val thridPerson = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
val FIRST = 1
val SECOND = 2
val THIRD = 3

fun solution(answers: IntArray): IntArray {
    val result = mutableMapOf<Int, Int>(Pair(FIRST, 0), Pair(SECOND, 0), Pair(THIRD, 0))
    val firstPersonLength = firstPerson.size
    val secondPersonLength = secondPerson.size
    val thirdPersonLength = thridPerson.size
    for (i in 0 until answers.size) {
        if (firstPerson[i % firstPersonLength] == answers[i])
            result.put(FIRST, result[FIRST]!! + 1)
        if (secondPerson[i % secondPersonLength] == answers[i])
            result.put(SECOND, result[SECOND]!! + 1)
        if (thridPerson[i % thirdPersonLength] == answers[i])
            result.put(THIRD, result[THIRD]!! + 1)
    }
    val max = Math.max(result[FIRST]!!, Math.max(result[SECOND]!!, result[THIRD]!!))
    //val max = result.maxBy { it.value }.value //이 코드가 버젼이 낮아서 안된다.
    return result.filter { it.value == max }.keys.sorted().toIntArray()
}

fun main() {
    solution(intArrayOf(1,2,3,4,5)).forEach { println(it) }
    solution(intArrayOf(1,3,2,4,2)).forEach { println(it) }
}
