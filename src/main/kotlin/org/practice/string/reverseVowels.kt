package org.practice.string

import java.util.Stack

fun reverseVowels(s: String): String {
    val stack = Stack<Char>()
    val stringy = StringBuilder(s)

    for (i in stringy.indices) {
        if (stringy[i].isVowel()) {
            stack.push(stringy[i])
//            stringy[i] = ' '
        }
    }

    for (i in stringy.indices) {
        if (stringy[i].isVowel()) {
            stringy[i] = stack.pop()
        }
    }

    return stringy.toString()
}

fun Char.isVowel(): Boolean {
    return this in "aeiouAEIOU"
}

fun main() {
    val input = "leetcode"
    val output = reverseVowels(input)
    println(output)
}