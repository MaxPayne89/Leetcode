package org.practice

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    var targetAtIndex = -1

    while (left <= right) {
        val middle = (left + right) / 2
        when {
            nums[middle] > target -> {
                right = middle - 1
            }
            nums[middle] < target -> {
                left  = middle + 1
            }
            else -> {
                targetAtIndex = middle
                break
            }
        }
    }
    return targetAtIndex
}

fun main() {
    val input = intArrayOf(-1,0,3,5,9,12)
    val a = search(input, 9)
    println(a)
}