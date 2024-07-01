package org.practice.array

import org.practice.string.romanNumeralsMap

fun moveZeroes(nums: IntArray): Unit {
    val copy = nums.filterNot { it == 0 }
    copy.forEachIndexed { index, num ->
        nums[index] = num
    }

    for (i in copy.lastIndex + 1 .. nums.lastIndex) {
        nums[i] = 0
    }
}

fun moveZeroesO(nums: IntArray) {
    var readPointer = 0
    var writePointer = 0

    while (readPointer <= nums.lastIndex) {
        if (nums[readPointer] == 0) {
            readPointer++
        } else {
            nums[writePointer] = nums[readPointer]
            writePointer++
            readPointer++
        }
    }

    while (writePointer <= nums.lastIndex) {
        nums[writePointer] = 0
        writePointer++
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroesO(nums)
    println(nums.contentToString())
}