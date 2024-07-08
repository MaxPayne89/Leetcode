package org.practice.prefixsum

import kotlin.math.max

fun largestAltitude(gain: IntArray): Int {
    var maxAlt = 0
    var currAlt = 0
    for (i in 1..gain.size) {
        currAlt += gain[i-1]
        maxAlt = max(maxAlt, currAlt)
    }
    return maxAlt
}

fun main() {
    val gain = intArrayOf(-5,1,5,0,-7)
    val result = largestAltitude(gain)
    println(result)
}