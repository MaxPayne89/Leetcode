package org.practice.string

import java.util.*

fun decodeString(s: String): String {
    val stack = Stack<Char>()
    for (char in s) {
        if (char == ']') {
            val decodedString = mutableListOf<Char>()
            while (stack.peek() != '[') {
                decodedString.add(stack.pop())
            }
            stack.pop()

            var base = 1
            var k = 0
            // get the number k
            while (stack.isNotEmpty() && stack.peek().isDigit()) {
                k += (stack.pop().code - '0'.code) * base
                base *= 10
            }

            while (k != 0) {
                for (j in decodedString.size - 1 downTo 0) {
                    stack.push(decodedString[j])
                }
                k--
            }
        } else {
            stack.push(char)
        }
    }
    val result = Array(stack.size) { 'a' }
    for (i in stack.lastIndex downTo 0) {
        result[i] = stack.pop()
    }
    return result.joinToString("")
}


fun main() {
//    val s = "3[a]2[bc]"
    val t = "3[a2[c]]"
//    val result = decodeString(s)
    val r2 = decodeString(t)
//    println(result)
    println(r2)
}