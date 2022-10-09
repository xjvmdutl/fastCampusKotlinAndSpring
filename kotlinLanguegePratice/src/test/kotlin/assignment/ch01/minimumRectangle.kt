package assignment.ch01

import java.util.Comparator.reverseOrder
import java.util.PriorityQueue

fun solution(sizes: Array<IntArray>): Int {
    val priorityQueueOne = PriorityQueue<Int>(reverseOrder())
    val priorityQueueTwo = PriorityQueue<Int>(reverseOrder())
    for(size in sizes){
        if(size[0] > size[1]) {
            priorityQueueOne.offer(size[0])
            priorityQueueTwo.offer(size[1])
        }else{
            priorityQueueOne.offer(size[1])
            priorityQueueTwo.offer(size[0])
        }
    }
    return priorityQueueOne.poll() * priorityQueueTwo.poll()
}

fun main() {
    println(solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))))
}