package org.practice

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val nums1Copy = IntArray(m)
    for (i in 0..<m) {
        nums1Copy[i] = nums1[i]
    }
    var readPointer1 = 0
    var readPointer2 = 0
    var writePointer = 0
    while (writePointer < n + m) {
        val num1 = catchOutOfBounds(nums1Copy, readPointer1)
        val num2 = catchOutOfBounds(nums2, readPointer2)
        if (num1 == null) {
            nums1[writePointer] = num2!!
            readPointer2 += 1
            writePointer += 1
            continue
        }
        if (num2 == null) {
            nums1[writePointer] = num1
            readPointer1 += 1
            writePointer += 1
            continue
        }

        if ( num1 <= num2) {
            nums1[writePointer] = num1
            readPointer1 += 1
        } else {
            nums1[writePointer] = nums2[readPointer2]
            readPointer2 += 1
        }
        writePointer += 1
    }
}

private fun catchOutOfBounds(arr: IntArray, index: Int) =
    try {
        arr[index]
    } catch (e: IndexOutOfBoundsException) {
        null
    }


fun main() {
    val numA = intArrayOf(1,2,3,0,0,0)
//    val numA = intArrayOf(1)
    val m = 3
    val numB = intArrayOf(2,5,6)
    val n = 3

    merge(numA,m, numB,n)
    println(numA)
}