package assignment.ch01

import java.util.*

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = n
    val lostSet = (lost.toSet() - reserve.toSet()).sorted().toSet()
    val reserveSet = (reserve.toSet() - lost.toSet()).sorted().toMutableSet()
    for (lostPerson in lostSet) {
        val prev = lostPerson - 1
        val next = lostPerson + 1
        if (reserveSet.contains(prev)) {
            reserveSet.remove(prev)
        } else if (reserveSet.contains(next)) {
            reserveSet.remove(next)
        } else {
            answer--
        }
    }
    return answer
}

fun main() {
    println(solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    println(solution(5, intArrayOf(2, 4), intArrayOf(3)))
    println(solution(3, intArrayOf(3), intArrayOf(1)))
}