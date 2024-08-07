package org.practice.array

import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var lefty = 0
    var righty = height.lastIndex
    var max = Int.MIN_VALUE
    while (lefty < righty) {
        val y = min(height[lefty], height[righty])
//        val x = righty - lefty
        max = max(max,(righty - lefty) * y)

        if (height[lefty] < height[righty]) {
            lefty++
        } else {
            righty--
        }
    }

    return max
}

fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)).toString()) // 49
}