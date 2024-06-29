package org.practice.string

fun mergeAlternately(word1: String, word2: String): String {
    val longest = maxOf(word1.length, word2.length)
    val merged = StringBuilder()
    for (i in 0 until longest) {
        if (i < word1.length) {
            merged.append(word1[i])
        }
        if (i < word2.length) {
            merged.append(word2[i])
        }
    }
    return merged.toString()
}

fun main() {
    val word1 = "abc"
    val word2 = "pqr"
    val a = mergeAlternately(word1, word2)
    println(a)
}