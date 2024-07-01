package org.practice.string

fun gcdOfStrings(str1: String, str2: String): String {
    if ((str1 + str2) != str2 + str1) {
        return ""
    }

    val gcdLength = gcd(str1.length, str2.length)
    return str1.substring(0, gcdLength)
}

private fun gcd(x: Int, y: Int): Int =
    if (y == 0) {
        x
    } else {
        gcd(y, x % y)
    }

fun main() {
    val str1 = "ABABAB"
    val str2 = "ABAB"
    val result = gcdOfStrings(str1, str2)
    println(result)
}