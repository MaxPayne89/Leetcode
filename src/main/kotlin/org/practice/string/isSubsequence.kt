package org.practice.string

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var i = 0
    var j = 0

    while (j < t.length) {
        if (i < s.length && s[i] == t[j]) {
            i++
            j++
        } else {
            j++
        }
    }

    return i == s.length
}

fun main() {
    val s = "b"
    val t = "abc"
    val result = isSubsequence(s, t)
    println(result)
}