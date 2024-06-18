package org.practice

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buyPointer = 0
    var sellPointer = buyPointer + 1
    while (buyPointer <= prices.lastIndex - 1) {
        val buyPrice = prices[buyPointer]
        val sellPrice = prices[sellPointer]
        if (sellPrice > buyPrice) {
            val profit = sellPrice - buyPrice
            maxProfit = if (profit > maxProfit) profit else maxProfit
            if (sellPointer == prices.lastIndex) {
                buyPointer++
                sellPointer = buyPointer + 1
            } else {
                sellPointer++
            }
        } else {
            buyPointer++
            sellPointer = buyPointer + 1
        }
    }
    return maxProfit
}

fun maxProfitOptimized(prices: IntArray): Int {
    var maxProfit = 0
    var minPriceSoFar = Int.MAX_VALUE

    for (i in prices.indices) {
        if (prices[i] < minPriceSoFar) {
            minPriceSoFar = prices[i]
        } else {
            maxProfit = maxOf(maxProfit, prices[i] - minPriceSoFar)
        }
    }
    return maxProfit
}

fun main() {
    val input1 = intArrayOf(7,1,5,3,6,4)
//    val input1 = intArrayOf(1,2)
    val a = maxProfitOptimized(input1)
    println(a)
}