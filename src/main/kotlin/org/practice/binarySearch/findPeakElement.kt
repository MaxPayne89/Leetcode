package org.practice.binarySearch

fun findPeakElement(nums: IntArray): Int {
    for (i in 0 until nums.lastIndex) {
        if (nums[i] > nums[i+1]) {
            return i
        }
    }
    return nums.lastIndex
}

fun findPeakElementRecursively(nums: IntArray): Int = recursiveBinarySearch(nums,0,nums.lastIndex)

fun recursiveBinarySearch(nums: IntArray, l: Int, r: Int): Int {
    if (l==r) return l
    val middle = l + (r - l) / 2
    return if (nums[middle] > nums[middle+1]) {
        recursiveBinarySearch(nums, l, middle)
    } else {
        recursiveBinarySearch(nums,middle+1,r)
    }
}

fun findPeakElementIter(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    while (l < r) {
        val mid = (l + r) / 2
        if (nums[mid] > nums[mid + 1]) r = mid
        else l = mid + 1
    }
    return l
}

fun main() {
    println(findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(findPeakElementRecursively(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
}