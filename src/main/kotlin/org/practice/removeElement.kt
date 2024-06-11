package org.practice

fun removeElement(nums: IntArray, `val`: Int): Int {
    val l = nums.filterNot { it == `val` }
    val k = l.size
    var readpointer = 0

    for (i in nums.indices) {
        if (readpointer > l.lastIndex) {
            nums[i] = Int.MAX_VALUE
        } else {
            nums[i] = l[readpointer]
            readpointer++
        }
    }

    return k
}

fun removeElementOptimized(nums: IntArray, `val`: Int): Int {
    var readPointer = 0
    var writePointer = 0

    while (readPointer <= nums.lastIndex) {
        if (nums[readPointer]  == `val`) {
            readPointer++
        } else {
            nums[writePointer] = nums[readPointer]
            writePointer++
            readPointer++
        }
    }

    return writePointer
}

fun main() {
    val input1 = intArrayOf(3,2,2,3)
//    val k = removeElement(input1, 3)
    val k = removeElementOptimized(input1, 3)
    println("$k $input1")
}