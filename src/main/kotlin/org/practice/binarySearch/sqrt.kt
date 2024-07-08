package org.practice.binarySearch

fun mySqrt(x: Int): Int {
    if (x == 0) return 0
    if (x == 1 || x == 2 || x == 3) return 1
    var left = 2
    var right = x / 2
    while (left <= right) {
        val middle = (left + right) / 2

        val square = middle.toLong() * middle
        when {
            (square == x.toLong()) -> {
                return middle
            }
            square > x -> {
                right = middle - 1
            }
            else -> {
                left = middle + 1
            }
        }
    }
    return (left + right) / 2
}

fun main() {
    val a = mySqrt(2147395599)
    println(a)
}