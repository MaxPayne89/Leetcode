package org.practice.slidingWindow

import kotlin.math.max

fun longestOnes(nums: IntArray, k: Int): Int {
    var longestSequence = 0
    var left = 0
    var right = 0
    var numZeroes = 0


    // While our window is in bounds
    while (right < nums.size) {
        // Increase numZeroes if the rightmost element is 0

        if (nums[right] == 0) {
            numZeroes++
        }

        //If our window is invalid, contract our window
        while (numZeroes > k) {
            if (nums[left] == 0) {
                numZeroes--
            }
            left++
        }

        // Update our longest sequence answer
        longestSequence = max(longestSequence.toDouble(), (right - left + 1).toDouble()).toInt()

        // Expand our window
        right++
    }
    return longestSequence
}

fun main() {
    val nums = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)
    val k = 2
    val result = longestOnes(nums, k)
    println(result)
}