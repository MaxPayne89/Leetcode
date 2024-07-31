package org.practice.dynamicProgramming

import kotlin.math.max

fun rob(nums: IntArray): Int {
    return dpTopDownHouseRobber(nums, nums.lastIndex)
}

private val mappy = mutableMapOf<Int, Int>()

fun dpTopDownHouseRobber(nums: IntArray, index: Int): Int {
    if (index == 0) return nums[0]
    if (index == 1) return max(nums[0], nums[1])

    return if (!mappy.contains(index)) {
        val rob = dpTopDownHouseRobber(nums, index - 2) + nums[index]
        val dontRob = dpTopDownHouseRobber(nums, index - 1)
        mappy[index] = max(rob, dontRob)
        mappy[index]!!
    } else {
        mappy[index]!!
    }
}

fun main() {
//    val nums = intArrayOf(1, 2, 3, 1)
//    val nums = intArrayOf(2,7,9,3,1)
    val nums = intArrayOf(1,1)
    val result = rob(nums)
    println(result)
}