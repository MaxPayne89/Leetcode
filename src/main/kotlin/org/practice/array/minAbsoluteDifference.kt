package org.practice.array

import kotlin.math.abs
import kotlin.math.min

fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    val sorted = arr.sorted()
    var minAbsDiff = Int.MAX_VALUE
    var answer = mutableListOf<List<Int>>()

    for (i in 1..arr.lastIndex) {
//        minAbsDiff = min(abs(sorted[i] - sorted[i-1]),minAbsDiff )
        if (sorted[i] - sorted[i-1] < minAbsDiff) {
            minAbsDiff = abs(sorted[i] - sorted[i-1])
            answer = mutableListOf(listOf(sorted[i-1], sorted[i]))
        } else if (sorted[i] - sorted[i-1] == minAbsDiff) {
            answer.add(listOf(sorted[i-1], sorted[i]))
        }
    }

//    for (j in 1..arr.lastIndex) {
//        if (abs(sorted[j] - sorted[j-1]) == minAbsDiff) {
//            answer.add(listOf(sorted[j-1], sorted[j]))
//        }
//    }

    return answer
}

fun main() {
    println(minimumAbsDifference(intArrayOf(4, 2, 1, 3)).toString()) // [[1, 2], [2, 3], [3, 4]]
}