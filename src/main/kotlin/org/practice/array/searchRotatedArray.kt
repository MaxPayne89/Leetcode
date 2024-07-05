package org.practice.array

fun search(nums: IntArray, target: Int): Int {
    var min = Int.MAX_VALUE to 0
    for (i in nums.indices) {
        if (nums[i] < min.first) {
            min = nums[i] to i
        }
    }
    val shiftValue = (min.second % nums.size)
    val sorted = nums.sorted().toIntArray()
    val index = bSearch(sorted, target)

    if (index == -1) {
        return index
    }

    return (index + shiftValue) % nums.size
}

private fun bSearch(nums: IntArray, target: Int): Int {
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
    val nums = intArrayOf(3,1)
    val target = 3
    val result = search(nums, target)
    println(result)
}