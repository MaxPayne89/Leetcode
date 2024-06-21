package org.practice

import kotlin.math.abs

fun sortedSquares(nums: IntArray): IntArray {
    val squared = nums.map { it * it }.toIntArray()
    return squared.sortedArray()
}

fun sortedSquaresOptimized(nums: IntArray): IntArray {
    var squaredAndSortedArr = IntArray(nums.size)
    var left = 0
    var right = nums.lastIndex

    for (writeIndex in nums.lastIndex downTo 0) {
        if (abs(nums[left]) > abs(nums[right])) {
            squaredAndSortedArr[writeIndex] = nums[left] * nums[left]
            left++
        } else {
            squaredAndSortedArr[writeIndex] = nums[right] * nums[right]
            right--
        }
    }
    return squaredAndSortedArr
}

fun main() {
    val input = intArrayOf(-4,-1,0,3,10)
    val a = sortedSquaresOptimized(input)
    println(a.contentToString())
}