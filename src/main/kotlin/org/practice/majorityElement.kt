package org.practice

fun majorityElement(nums: IntArray): Int {
    if (nums.size == 1) return nums.first()
    val majority =nums.size / 2
    var map: MutableMap<Int, Int> = mutableMapOf()
    for (i in nums.indices) {
        if (map[nums[i]] != null) {
            map[nums[i]] = map[nums[i]]!! + 1
            if (map[nums[i]]!! > majority) return nums[i]
        } else {
            map[nums[i]] = 1
        }
    }
    return 1
}

fun majorityElementOptimized(nums: IntArray): Int {
    val sorted = nums.sortedArray()
    val majorityIndex = if (nums.size % 2 == 0) (nums.size / 2) - 1 else nums.size / 2
    return sorted[majorityIndex]
}

fun main() {
    val arr = intArrayOf(2,2,1,1,1,2,2)
    val m = majorityElementOptimized(arr)
    println(m)
}