package org.practice.array

fun findNumbers(nums: IntArray): Int {
    var evenDigits = 0
    nums.forEach { num ->
        if (divideAndCount(num) % 2 == 0) {
            evenDigits++
        }
    }
    return evenDigits
}

fun main() {
    val input = intArrayOf(12,345,2,6,7896)
    val a = findNumbers(input)
    println(a)

//    println(divideAndCount(7896))
}

private fun divideAndCount(num: Int): Int {
    var number = num
    var counter = 0
    while (number != 0) {
        number /= 10
        counter++
    }
    return counter
}