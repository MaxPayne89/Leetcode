package org.practice

fun lengthOfLastWord(s: String): Int {
    val charArr = s.toCharArray()
    var length = 0
    for (i in charArr.lastIndex downTo 0) {
        if (charArr[i].isLetter()) {
            length++
        } else {
            if (length > 0) {
                break
            }
        }
    }
    return length
}

fun main() {
    val input = "Hello World"
    val a = lengthOfLastWord(input)
    println(a)
}