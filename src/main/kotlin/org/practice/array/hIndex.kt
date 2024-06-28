package org.practice.array

import java.util.*


fun hIndex(citations: IntArray): Int {
    Arrays.sort(citations)
    var i = 0
    while (i < citations.size && citations[citations.size - 1 - i] > i) {
        i++
    }
    return i
}

fun main() {
    val input = intArrayOf(3,0,6,1,5)
    val a = hIndex(input)
    println(a)
}