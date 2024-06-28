package org.practice.string

fun reverseString(s: CharArray): Unit {
    var rightIndex = s.lastIndex
    var leftIndex= 0

    while (rightIndex > leftIndex) {
        val r = s[rightIndex]
        val l = s[leftIndex]

        s[leftIndex] = r
        s[rightIndex] = l

        rightIndex -= 1
        leftIndex += 1
    }
}