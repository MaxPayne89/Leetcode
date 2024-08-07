package org.practice.slidingWindow

import org.practice.string.isVowel
import kotlin.math.max

fun maxVowels(s: String, k: Int): Int {
    var max = 0
    for (i in 0..<k) {
        if (s[i].isVowel()) {
            max++
        }
    }
    var counter = max

    for (lefty in k..s.lastIndex) {
        if (s[lefty].isVowel()) {
            counter++
        }
        if (s[lefty - k].isVowel()) {
            counter--
        }
        max = max(counter, max)
    }

    return max
}

fun main() {
    println(maxVowels("abciiidef", 3)) // 3
//    println(maxVowels("aeiou", 2)) // 2
//    println(maxVowels("leetcode", 3)) // 2
//    println(maxVowels("rhythms", 4)) // 0
//    println(maxVowels("tryhard", 4)) // 1
}