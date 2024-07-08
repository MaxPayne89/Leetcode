package org.practice.binarySearch

class Solution {
    fun guessNumber(n:Int):Int {
        var low = 1L
        var high = n.toLong()

        while (low <= high) {
            when (guess(((low + high) / 2).toInt())) {
                1 -> {
                    low = ((low + high) / 2) + 1
                }
                -1 -> {
                    high = ((low + high) / 2) - 1
                }
                0 -> {
                    return ((low + high) / 2).toInt()
                }
            }
        }
        return 0
    }
}

fun guess(n: Int): Int {
    val pick = 1702766719
    return when {
        n < pick -> 1
        n > pick -> -1
        else -> 0
    }
}

fun main() {
    val s = Solution()
    val a = s.guessNumber(2126753390)
    println(a)
}

//2126753390
//1702766719