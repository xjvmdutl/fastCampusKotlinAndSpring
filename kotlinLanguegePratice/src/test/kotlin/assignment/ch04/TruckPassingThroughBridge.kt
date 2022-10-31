package assignment.ch04

import java.util.LinkedList

//트럭
data class Truck(val time: Int, val weight: Int)

//다리 상태(조금이라도 있다/비어있다)
enum class BridgeStatus {
    FULL, EMPTY //차있거나, 빈 상태
}

// 다리
class Bridge(
    private var trucks: LinkedList<Truck>, //다리를 지나는 트럭
    private var status: BridgeStatus, //다리 상태
    private val length: Int, //다리 길이
    private val weight: Int  //최대 무게
) {
    private fun changeStatus() { //다리 상태를 변경
        status = if (trucks.isEmpty()) { //다리를 지나는 트럭이 없다면
            BridgeStatus.EMPTY
        } else { //그 외
            BridgeStatus.FULL
        }
    }

    //다리가 비어있는 상태와 다리를 건너는 트럭이 없다면 true / 그 외 false
    fun isEmpty(): Boolean = status == BridgeStatus.EMPTY && trucks.isEmpty()

    //다리 탈출
    fun escapeBridgeWeight(): Int {

        //다리에 있는 트럭을 시간을 하나씩 줄였을 때, 그 값이 <= 0 이면, 다리를 탈출한 거로 가정 -> 탈츨한 트럭들을 무게를 더한다
        val sum = trucks.asSequence().filter { it.time - 1 <= 0 }.map { it.weight }.sum()

        // 다리를 건너는 트럭들 초기화(시간을 하나씩 감소 후, 그 시간이 0보다 큰것만 list로 변환 후, LinkedList에 담는다)
        trucks = LinkedList(trucks.asSequence().map { it.copy(time = it.time - 1) }
            .filter { it.time > 0 }.toList())
        changeStatus() //다리 상태 변경
        return sum
    }

    //다리에 들어올 수 있는 상태라면
    fun isInToBridge(currentBridgeWeight: Int, truckWeight: Int): Boolean =
        currentBridgeWeight + truckWeight <= weight

    //다리에 들어와라
    fun inToBridge(waits: LinkedList<Int>): Int {
        val weight = waits.poll() //대기하고 있던 트럭 무게
        trucks.offer(Truck(length, weight)) //다리에 들어온다
        changeStatus() //다리 상태 변경 (반드시 FULL 상태)
        return weight //들어온 트럭 무게 반환
    }
}

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    var currentBridgeWeight = 0 //현재 다리 무게
    val waits = LinkedList(truck_weights.toList()) //대기하는 트럭들
    val bridge = Bridge(LinkedList<Truck>(), BridgeStatus.EMPTY, bridge_length, weight) //다리 초기화 -> 처음에 비어있다
    while (!(bridge.isEmpty() && waits.isEmpty())) { //다리가 비어있고, 대기하는 트럭도 없으면 while문 종료
        answer++ //시간 증가
        currentBridgeWeight -= bridge.escapeBridgeWeight() //다리를 탈출한 트럭 무게 리턴
        if (waits.isEmpty()) { //대기하는 트럭이 비어있을 수 있지만, 다리가 건너는 트럭이 있을 수 있으므로 continue
            continue
        } else if (bridge.isInToBridge(currentBridgeWeight, waits.peek())) { //대기하고 있는 트럭이 있다면, 다리를 건널 수 있는지 확인
            currentBridgeWeight += bridge.inToBridge(waits) //다리를 건너자
        }
    }
    return answer
}


fun main() {
    println(solution(2, 10, intArrayOf(7, 4, 5, 6)))
    println(solution(100, 100, intArrayOf(10)))
    println(solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
}