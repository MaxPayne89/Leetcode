package org.practice.array

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val set = nums.toSet()

    val listy = mutableListOf<Int>()

    for (i in 1..nums.size) {
        if (!set.contains(i)) {
            listy.add(i)
        }
    }

    return listy
}

fun main() {
    val nums = intArrayOf(4,3,2,7,8,2,3,1)
    val result = findDisappearedNumbers(nums)
    println(result)
}