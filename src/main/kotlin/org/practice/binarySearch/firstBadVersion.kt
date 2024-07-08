package org.practice.binarySearch

var mappy = mutableMapOf<Int, Boolean>()

fun firstBadVersion(n: Int) : Int {
    var left = 1
    var right = n
    while (left <= right) {
        val middle = left + (right - left) / 2
        when {
            isBadVersion(middle) && !isBadVersion(middle - 1) -> {
                return middle
            }
            isBadVersion(middle) && isBadVersion(middle - 1) -> {
                right = middle
            }
            !isBadVersion(middle) && !isBadVersion(middle + 1) -> {
                left = middle + 1
            }
            !isBadVersion(middle) && isBadVersion(middle + 1) -> {
                return middle + 1
            }
        }
    }
    return 1
}

private fun isBadVersionWithMap(n: Int): Boolean =
    mappy[n]?.let {
        return it
    } ?: run {
        val isBad = isBadVersion(n)
        mappy[n] = isBad
        isBad
    }


private fun isBadVersion(n: Int) : Boolean {
    val version = 2
    return n >= version
}

fun main() {
    val n = 2
    val result = firstBadVersion(n)
    println(result)
}