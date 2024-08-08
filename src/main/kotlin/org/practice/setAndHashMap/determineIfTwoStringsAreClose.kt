package org.practice.setAndHashMap

fun closeStrings(word1: String, word2: String): Boolean {
    val wordy1 = mutableMapOf<Char, Int>()
    val wordy2 = mutableMapOf<Char, Int>()
    for (c in word1) {
        wordy1[c] = wordy1.getOrDefault(c,0) + 1
    }
    for (c in word2) {
        wordy2[c] = wordy2.getOrDefault(c,0) + 1
    }

    if (wordy1.keys.sorted() != wordy2.keys.sorted()) {
        return false
    }

    return wordy1.values.sorted() == wordy2.values.sorted()
}

fun main() {
    val word1 = "abc"
    val word2 = "bca"
    val result = closeStrings(word1, word2)
    println(result)
}