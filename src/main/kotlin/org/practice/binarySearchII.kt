package org.practice

fun searchII(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1

    var left = 0
    var right: Int = nums.size - 1
    while (left < right) {
        // Prevent (left + right) overflow
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }


    // Post-processing:
    // End Condition: left == right
    if (nums[left] == target) return left
    return -1
}

fun main() {
    val input = intArrayOf(-1,0,3,5,9,12,15,23,25,47,60)
    val a = searchII(input, 5)
    println(a)
}