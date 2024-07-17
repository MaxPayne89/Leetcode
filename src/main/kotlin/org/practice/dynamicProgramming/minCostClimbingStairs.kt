package org.practice.dynamicProgramming

import kotlin.math.min

private val mappy = mutableMapOf<Int, Int>()

fun minCostClimbingStairs(cost: IntArray): Int {
    return dpBottomUp(cost)
}

private fun dpTopDown(cost: IntArray, index: Int): Int {
    if (index <= 1) return 0

    return if (!mappy.contains(index)) {
        val downOne = dpTopDown(cost, index - 1) + cost[index - 1]
        val downTwo = dpTopDown(cost, index - 2) + cost[index - 2]
        mappy[index] = min(downOne, downTwo)
        mappy[index]!!
    } else {
        mappy[index]!!
    }
}

private fun dpBottomUp(cost: IntArray): Int {
    val minCost = Array(cost.size + 1) { 0 }

    for (i in 2 until minCost.size) {
        minCost[i] = min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i-2])
    }
    return minCost.last()
}

fun main() {
    val cost = intArrayOf(1,100,1,1,1,100,1,1,100,1)
//    val cost = intArrayOf(10,15,20)
    val result = minCostClimbingStairs(cost)
    println(result)
}