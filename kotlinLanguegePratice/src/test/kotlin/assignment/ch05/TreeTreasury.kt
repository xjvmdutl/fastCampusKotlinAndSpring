package assignment.ch05

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

val dx: IntArray = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
val dy: IntArray = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)


data class Block(var food: Int, val trees: PriorityQueue<Int>)


class Land(
    private val fertilizers: Array<IntArray>,
    var blocks: Array<Array<Block>>,
    private val n: Int,
) {
    /**
     * 살아남은 나무들의 합
     */
    fun getArriveTrees(): Int {
        return blocks.sumOf { rowBlocks -> rowBlocks.sumOf { block -> block.trees.size } }
    }

    /**
     * 봄 : 나무가 있으면 영양분을 먹는다
     */
    fun spring(): Array<Array<Int>> {
        val deathTrees = Array(n) { Array(n) { 0 } }
        blocks.forEachIndexed { yIndex, y ->
            y.forEachIndexed { xIndex, block ->
                if (!block.trees.isEmpty()) {
                    deathTrees[yIndex][xIndex] = eatFood(xIndex, yIndex, block)
                }
            }
        }
        return deathTrees
    }

    /**
     * 영양분을 먹는다 -> 우선순위 queue 사용
     */
    private fun eatFood(x: Int, y: Int, block: Block): Int {
        val tmpQueue = PriorityQueue<Int>()
        while (!block.trees.isEmpty() && block.food >= block.trees.peek()) {
            val currentFood = block.trees.poll()
            block.food -= currentFood
            tmpQueue.offer(currentFood + 1)
        }
        val result = blocks[y][x].trees.sumOf { it / 2 }
        blocks[y][x] = Block(block.food, tmpQueue)
        return result
    }

    /**
     * 여름 : 죽은 나무들이 영양분이 된다
     */
    fun summer(deathTrees: Array<Array<Int>>) {
        deathTrees.forEachIndexed { yIndex, y ->
            y.forEachIndexed { xIndex, deadTree ->
                if (deadTree > 0)
                    blocks[yIndex][xIndex].food += deadTree
            }
        }
    }

    /**
     * 가을 : 나무들이 번식한다
     */
    fun fall() {
        blocks.forEachIndexed { yIndex, y ->
            y.forEachIndexed { xIndex, block ->
                if (block.trees.size > 0)
                    breeding(xIndex, yIndex, block.trees)
            }
        }
    }

    /**
     * queue에 모든 데이터를 돌면서 5의 배수이면 사방에 양분을 추가한다
     */
    private fun breeding(xIndex: Int, yIndex: Int, trees: PriorityQueue<Int>) {
        for (tree in trees) {
            if (tree % 5 == 0) {
                dx.forEachIndexed { index, value ->
                    val nx: Int = xIndex + dx[index]
                    val ny: Int = yIndex + dy[index]
                    if (isRange(nx, ny)) {
                        blocks[ny][nx].trees.offer(1)
                    }
                }
            }
        }
    }

    /**
     * 범위안에 포함이 되어야 한다.
     */
    private fun isRange(nx: Int, ny: Int): Boolean {
        return nx in 0 until n && ny in 0 until n;
    }

    /**
     * 겨울 : 양분을 추가한다
     */
    fun winter() {
        fertilizers.forEachIndexed { yIndex, y ->
            y.forEachIndexed { xIndex, fertilizer ->
                blocks[yIndex][xIndex].food += fertilizer
            }
        }
    }

}

fun solution(
    fertilizers: Array<IntArray>,
    trees: Array<Array<Block>>,
    n: Int,
    k: Int
): Int {
    val sangDoLand = Land(fertilizers, trees, n)
    for (i in 1..k) {
        val deathTrees = sangDoLand.spring()
        sangDoLand.summer(deathTrees)
        sangDoLand.fall()
        sangDoLand.winter()
    }
    return sangDoLand.getArriveTrees()
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, K) = reader.readLine().split(" ").map { it.toInt() }
    val fertilizers = Array(N) { IntArray(N) }
    val trees = Array(N) { Array(N) { Block(5, PriorityQueue<Int>()) } }
    for (i: Int in 1..N) {
        fertilizers[i - 1] = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i: Int in 1..M) {
        val (x, y, z) = reader.readLine().split(" ").map { it.toInt() }
        trees[x - 1][y - 1].trees.add(z)
    }
    println(solution(fertilizers, trees, N, K))
    reader.close()
}