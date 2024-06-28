package org.practice.string

fun strStr(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

fun strStrSlidingWindow(haystack: String, needle: String): Int {
    val n = haystack.length
    val m = needle.length

    for (windowStart in 0 .. n-m) {
        for (i in 0..needle.lastIndex) {
            if (needle[i] != haystack[windowStart + i]) {
                break
            }
            if (i == m - 1) {
                return windowStart
            }
        }
    }
    return -1
}

fun main() {
    val haystack = "sadbutsad"
    val needle = "sad"
    val a = strStr(haystack, needle)
    println(a)
}