package org.practice.heap

import java.util.*

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val mappy = mutableMapOf<Int, Int>()
    nums.forEach { num ->
        mappy[num] = mappy.getOrDefault(num, 0) + 1
    }
    val minHeap = PriorityQueue<Pair<Int, Int>>(k,compareBy { it.second })
    mappy.forEach { (key, value) ->
        if (minHeap.size == k) {
            if (minHeap.peek().second < value) {
                minHeap.poll()
                minHeap.add(key to value)
            }
        } else {
            minHeap.add(key to value)
        }
    }
    val list = minHeap.map {
        it.first
    }
    return list.toIntArray()
}

fun main() {
    val nums = intArrayOf(4,1,-1,2,-1,2,3)
    val k = 2
    val result = topKFrequent(nums, k)
    println(result.contentToString())
}