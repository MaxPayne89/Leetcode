package org.practice.dynamicProgramming

import kotlin.math.max

fun deleteAndEarn(nums: IntArray): Int {
    var maxNum = Int.MIN_VALUE
    for (num in nums) {
        points[num] = points.getOrDefault(num, 0) + num
        maxNum = max(num, maxNum)
    }

    return maxPoints(maxNum)
}

private val points = mutableMapOf<Int, Int>()
private val cache = mutableMapOf<Int, Int>()

private fun maxPoints(num: Int): Int {
    if (num == 0) {
        return 0
    }

    if (num == 1) {
        return points.getOrDefault(1,0)
    }

    if (cache.contains(num)) {
        return cache[num]!!
    }

    val gain = points.getOrDefault(num,0)
    cache[num] = max(maxPoints(num - 1), maxPoints(num - 2) + gain)
    return cache[num]!!
}


fun main() {
    val result = deleteAndEarn(intArrayOf(2,2,3,3,3,4))
    println(result)
}