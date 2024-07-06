package org.practice.slidingWindow

import kotlin.math.max

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0.0
    for (i in 0 until k) sum += nums[i]
    var res = sum
    for (i in k until nums.size) {
        sum += nums[i] - nums[i - k]
        res = max(res, sum)
    }
    return res / k
}

fun main() {
    val nums = intArrayOf(1,12,-5,-6,50,3)
    println(nums.size)
    val k = 4
    val result = findMaxAverage(nums, k)
    println(result)
}