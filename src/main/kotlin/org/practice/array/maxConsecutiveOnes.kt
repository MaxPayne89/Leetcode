package org.practice.array

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var onesInARowMax = 0
    var currOnesInARow = 0

    for (i in nums.indices) {
        if (nums[i] == 1) {
            currOnesInARow++
        } else {
            onesInARowMax = if (currOnesInARow > onesInARowMax) currOnesInARow else onesInARowMax
            currOnesInARow = 0
        }
    }
    return maxOf(onesInARowMax, currOnesInARow)
}

fun main() {
    val input = intArrayOf(1,1,0,1,1,1)
    val a = findMaxConsecutiveOnes(input)
    println(a)
}