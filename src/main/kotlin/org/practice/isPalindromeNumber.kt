package org.practice

fun isPalindrome(x: Int): Boolean {
    val numAsCharArr= x.toString().toCharArray()
    var leftIndex = 0
    var rightIndex = numAsCharArr.lastIndex
    while (leftIndex < rightIndex) {
        val a = numAsCharArr[leftIndex]
        val b = numAsCharArr[rightIndex]
        if (a == b) {
            leftIndex += 1
            rightIndex -= 1
        } else {
            return false
        }
    }
    return  true
}

fun isPalindromeNoString(x: Int): Boolean {
    var palindrome = x
    var rev = 0
    while (palindrome != 0) {
        val lastDigit = palindrome % 10
        rev = (rev*10)+lastDigit
        palindrome /= 10
    }
    return x > 0 && x == rev || x==0
}

fun main() {
    val p = isPalindrome(11211)
    val p2 = isPalindromeNoString(11211)
    println(p)
    println(p2)
}