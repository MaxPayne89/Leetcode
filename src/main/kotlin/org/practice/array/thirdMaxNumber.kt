package org.practice.array

fun thirdMax(nums: IntArray): Int {
    val maximum = nums.max()
    if (nums.size < 3) {
        return maximum
    }
    val sorted = nums.sorted()

    var unique = 1
    for (i in sorted.lastIndex downTo 1) {
        if (sorted[i] != sorted[i-1]) {
            unique++
        }
        if (unique == 3) {
            return sorted[i-1]
        }
    }

    return maximum
}

fun main() {
    val nums = intArrayOf(3,2,1)
    val result = thirdMax(nums)
    println(result)
}