package org.practice.slidingWindow

import kotlin.math.max

fun longestSubarray(nums: IntArray): Int {
    var lefty = 0
    var righty = 0
    var maxSeq = 0
    var numZeroes = 0

    while (righty < nums.size) {
        if (nums[righty] == 0) {
            numZeroes++
        }

        while (numZeroes > 1) {
            if (nums[lefty] == 0) {
                numZeroes--
            }
            lefty++
        }

        maxSeq = max(maxSeq, righty - lefty + 1)

        righty++
    }

    return if (numZeroes == 1 || maxSeq == nums.size) maxSeq - 1 else maxSeq
}

fun main() {
//    val nums = intArrayOf(1,1,0,0,1)
    val nums = intArrayOf(1,1,1)
    val numsy = intArrayOf(0,1,1,1,0,1,1,0,)
    val result = longestSubarray(nums)
    val result2 = longestSubarray(numsy)
    println(result)
    println(result2)
}