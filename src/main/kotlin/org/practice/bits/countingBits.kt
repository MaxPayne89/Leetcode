package org.practice.bits

fun countBits(n: Int): IntArray {
    val ans = Array(n+1) { 0 }
    var offset = 1

    for (i in 1..n) {
        if (offset * 2 == i) {
            offset = i
        }
        ans[i] = 1 + ans[i - offset]
    }
    return ans.toIntArray()
}

fun main() {
    val result = countBits(2)
    println(result.contentToString())
}