package org.practice

fun productExceptSelf(nums: IntArray): IntArray {
    val prefixList = Array(nums.size) {1}
    val suffixList = Array(nums.size) {1}
    val answer = Array(nums.size) {1}

    for (i in 1..nums.lastIndex) {
        prefixList[i] = nums[i-1] * prefixList[i-1]
    }
    for (i in nums.lastIndex-1 downTo 0) {
        suffixList[i] = nums[i+1] * suffixList[i+1]
    }
    for (i in nums.indices) {
        answer[i] = prefixList[i] * suffixList[i]
    }

    return answer.toIntArray()
}

fun main() {
    val input = intArrayOf(1,2,3,4)
    val a = productExceptSelf(input)
    println(a.joinToString())
}