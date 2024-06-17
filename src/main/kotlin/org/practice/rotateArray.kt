package org.practice

fun rotate(nums: IntArray, k: Int): Unit {
    val copyArr = nums.copyOf()
    val n = nums.size
    copyArr.forEachIndexed { index, i ->
        val rotatedIndex = (index + k) % n
        nums[rotatedIndex] = i
    }
}

fun main() {
    val input1 = intArrayOf(1,2,3,4,5,6,7)
    rotate(input1, 3)
    println(input1.toList())
}