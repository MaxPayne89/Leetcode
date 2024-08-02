package org.practice.array

fun increasingTriplet(nums: IntArray): Boolean {
    var smallNum = Int.MAX_VALUE
    var midNum = Int.MAX_VALUE

    for (num in nums) {
        if (num <= smallNum) {
            smallNum = num
        } else if (num <= midNum) {
            midNum = num
        } else {
            return true
        }
    }
    return false
}

fun main() {
    val result = increasingTriplet(intArrayOf(2,1,5,0,4,6))
    println(result)
}