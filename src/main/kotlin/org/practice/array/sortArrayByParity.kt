package org.practice.array

fun sortArrayByParity(nums: IntArray): IntArray {
    if (nums.size == 1) return nums

    val copy = Array(nums.size) {0}
    nums.forEachIndexed { index, num ->
        copy[index] = num
    }

    var writePointer = 0

    copy.forEach { num ->
        if (num % 2 == 0) {
            nums[writePointer] = num
            writePointer++
        }
    }

    copy.forEach { num ->
        if (num % 2 != 0) {
            nums[writePointer] = num
            writePointer++
        }
    }

    return nums
}

fun sortArrayByParityO(nums: IntArray): IntArray {
    var i = 0
    var j: Int = nums.size - 1
    while (i < j) {
        if (nums[i] % 2 > nums[j] % 2) {
            val tmp: Int = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }

        if (nums[i] % 2 == 0) i++
        if (nums[j] % 2 == 1) j--
    }

    return nums
}

fun main() {
    val nums = intArrayOf(0,1,2)
    val result = sortArrayByParity(nums)
    println(result.contentToString())
}