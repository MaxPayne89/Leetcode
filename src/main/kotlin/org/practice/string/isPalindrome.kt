package org.practice.string

fun isPalindrome(s: String): Boolean {
    val cleansed = s.lowercase().filter { it.isLetterOrDigit() }
    var front = 0
    var back = cleansed.lastIndex

    while (front < back) {
        if (cleansed[front] == cleansed[back]) {
            front++
            back--
        } else {
            return false
        }
    }
    return true
}

fun main() {
    val input = "A man, a plan, a canal: Panama"
    val output = isPalindrome(input)
    println(output)
}