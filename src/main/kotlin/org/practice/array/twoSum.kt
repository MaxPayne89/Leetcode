package org.practice.array

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = nums.withIndex().associateBy(keySelector = {target - it.value}, valueTransform = {it.index})
    nums.forEachIndexed {index, value ->
        val complementIndex = map[value]
        complementIndex?.let {
            if (index == complementIndex) {
                Unit
            } else {
                return intArrayOf(index, complementIndex)
            }
        }
    }
    return intArrayOf()
}

fun main() {
    val arr = intArrayOf(2,7,11,15)
    val t = twoSum(arr, 9)
    println(t)
}