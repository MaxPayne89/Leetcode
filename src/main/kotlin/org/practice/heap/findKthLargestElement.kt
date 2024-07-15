package org.practice.heap

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(compareByDescending { it } )
    nums.forEach { maxHeap.add(it) }
    repeat(k - 1) {
        maxHeap.poll()
    }
    return maxHeap.poll()
}

fun findKthLargestMinHeap(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>(k)
    for (i in 0 until k) {
        minHeap.add(nums[i])
    }
    for (i in k..nums.lastIndex) {
        if (nums[i] > minHeap.peek()) {
            minHeap.poll()
            minHeap.add(nums[i])
        }
    }

    return minHeap.poll()
}

fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 4)
    val k = 2
    val result = findKthLargestMinHeap(nums, k)
    println(result)
}