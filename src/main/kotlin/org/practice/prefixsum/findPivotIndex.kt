package org.practice.prefixsum

fun pivotIndex(nums: IntArray): Int {
    val totalSum = nums.sum()
    var leftPSum = 0

    for (i in nums.indices) {
        if (leftPSum == totalSum - leftPSum - nums[i]) {
            return i
        }

        leftPSum += nums[i]
    }
    return -1
}

fun main() {
    val nums = intArrayOf(1, 7, 3, 6, 5, 6)
//    val nums = intArrayOf(1,2,3)
//    val nums = intArrayOf(2,1,-1)
//    val nums = intArrayOf(-1,-1,-1,-1,-1,-1)
    val result = pivotIndex(nums)
    println(result)
}