package org.practice.dynamicProgramming

private val mappy = mutableMapOf<Int, Int>()

fun tribonacciTopDown(n: Int): Int {
    if (n == 0 ) return 0
    if (n <= 2 ) return 1

    return if (mappy.contains(n)) {
        mappy[n]!!
    } else {
        mappy[n] = tribonacciTopDown(n-3) + tribonacciTopDown(n-2) + tribonacciTopDown(n-1)
        mappy[n]!!
    }
}

fun tribonacciBottomUp(n: Int): Int {
    if (n < 3) {
        return if (n > 0) 1 else 0
    }

    val dp = Array(n+1) {0}
    dp[1] = 1
    dp[2] = 1

    for (i in 3..n) {
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    }
    return dp[n]
}

fun main() {
    val n = 25
    val result = tribonacciBottomUp(n)
    println(result)
}