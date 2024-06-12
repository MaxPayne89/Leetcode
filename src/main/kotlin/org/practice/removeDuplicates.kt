package org.practice

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size == 1) return 1
    var readerPointer = 1
    var writerPointer = 1

    while (readerPointer <= nums.lastIndex) {
        val readNumber = nums[readerPointer]
        val priorNumber = nums[readerPointer - 1]
        if (readNumber == priorNumber) {
            readerPointer++
        } else {
            nums[writerPointer] = readNumber
            readerPointer++
            writerPointer++
        }
    }

    return writerPointer
}

fun removeDuplicates2(nums: IntArray): Int {
    var j = 1
    var count = 1

    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1]) {
            count++
        } else {
            count = 1
        }
        if (count <= 2) {
            nums[j++] = nums[i]
        }
    }
    return j
}

fun main() {
    val input1 = intArrayOf(1,1,1,2,2,3)
    val a = removeDuplicates2(input1)
    println("unique elements:$a  arr: $input1")
}