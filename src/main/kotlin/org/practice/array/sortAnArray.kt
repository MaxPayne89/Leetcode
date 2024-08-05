package org.practice.array

import java.util.PriorityQueue

fun sortArray(nums: IntArray): IntArray {
    val minHeap = PriorityQueue<Int>()

    nums.forEach { num -> minHeap.add(num) }

    for (i in 0..nums.lastIndex) {
        nums[i] = minHeap.poll()
    }

    return nums
}

fun main() {
    println(sortArray(intArrayOf(5, 2, 3, 1)).contentToString()) // [1, 2, 3, 5]
}