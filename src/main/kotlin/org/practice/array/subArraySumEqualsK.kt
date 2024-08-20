package org.practice.array

fun subarraySum(nums: IntArray, k: Int): Int {
    val prefixSumMappy: MutableMap<Int, Int> = mutableMapOf()
    prefixSumMappy[0] = 1
    var result = 0
    var prefixSum = 0
    nums.forEach { num ->
        prefixSum += num
        val diff = prefixSum - k
        result += prefixSumMappy.getOrDefault(diff, 0)
        prefixSumMappy[prefixSum] = 1 + prefixSumMappy.getOrDefault(prefixSum, 0)
    }

    return result
}

fun main() {
//    println(subarraySum(intArrayOf(1, 1, 1), 2)) // 2
//    println(subarraySum(intArrayOf(1, 2, 3), 3)) // 2
//    println(subarraySum(intArrayOf(1, 2, 3, 4, 5), 10)) // 1
    // provide an array of integers and a target sum where it matches more than 3 times
    println(subarraySum(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10)) // 3
}