package org.practice.array

fun heightChecker(heights: IntArray): Int {
    var youWrongBro = 0
    val sorted = heights.sorted()

    heights.forEachIndexed { index, height ->
        if (sorted[index] != height) {
            youWrongBro++
        }
    }
    return youWrongBro
}

fun main() {
    val heights = intArrayOf(5,1,2,3,4)
    val result = heightChecker(heights)
    println(result)
}