package org.practice.string

import java.util.Stack

fun removeStars(s: String): String {
//    val stack = Stack<Char>()
//    for (i in s.indices) {
//        stack.push(s[i])
//        if (stack.peek() == '*') {
//            stack.pop()
//            stack.pop()
//        }
//    }
//    return stack.elements().toList().joinToString(separator = "")

    val result = StringBuilder()
    for (char in s) {
        if (char == '*') {
            if (result.isNotEmpty()) {
                result.deleteCharAt(result.length - 1)
            }
        } else {
            result.append(char)
        }
    }
    return result.toString()
}

fun main() {
//    val s = "a*b*c"
    val s = "leet**cod*e"
    val result = removeStars(s)
    println(result)
}