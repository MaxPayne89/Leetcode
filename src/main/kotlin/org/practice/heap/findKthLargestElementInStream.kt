package org.practice.heap

import java.util.PriorityQueue
import kotlin.math.min

class KthLargest(private val k: Int, nums: IntArray) {

    private val minHeap = PriorityQueue<Int>(k)

    init {
        nums.forEach { num ->
            minHeap.offer(num)
        }
        while (minHeap.size > k) {
            minHeap.poll()
        }
    }

    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }

}

fun main() {
    val kthLargest = KthLargest(7, intArrayOf(-10,1,3,1,4,10,3,9,4,5,1))
    println(kthLargest.add(3))
    println(kthLargest.add(2))
    println(kthLargest.add(3))
    println(kthLargest.add(1))
    println(kthLargest.add(2))
    println(kthLargest.add(4))
    println(kthLargest.add(5))
    println(kthLargest.add(5))
    println(kthLargest.add(6))
//    println(kthLargest.add(7))
//    println(kthLargest.add(7))
}