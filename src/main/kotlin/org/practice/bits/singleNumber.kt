package org.practice.bits

fun singleNumber(nums: IntArray): Int {
    var a = 0
    for (num in nums) {
        a = a.xor(num)
    }
    return a
}

fun main() {
    val nums = intArrayOf(4,1,2,1,2)
    val result = singleNumber(nums)
    println(result)
}