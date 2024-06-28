package org.practice.array

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

fun maxProfitTwo(prices: IntArray): Int {
    var profit = 0
    var buyPointer = 0
    var sellPointer = 1

    while (sellPointer <= prices.lastIndex) {
        val buyPrice = prices[buyPointer]
        val sellPrice = prices[sellPointer]
        if (sellPrice > buyPrice) {
            if (sellPointer < prices.lastIndex && prices[sellPointer] < prices[sellPointer+1]) {
                sellPointer++
            } else {
                profit += sellPrice - buyPrice
                buyPointer = sellPointer
                sellPointer = buyPointer+1
            }
        } else {
            buyPointer++
            sellPointer++
        }
    }
    return profit
}

fun maxProfitTwoOptimized(prices: IntArray): Int {
    var totalProfit = 0
    var valley = Int.MAX_VALUE
    var peak = valley

    for (i in prices.indices) {
        if (prices[i] < peak) {
            totalProfit += peak - valley
            valley = prices[i]
            peak = valley
        } else {
            peak = prices[i]
        }
    }
    totalProfit += peak - valley
    return totalProfit
}

fun main() {
//    val input1 = intArrayOf(7,1,5,3,6,4)
    val input1 = intArrayOf(1,2,3,4,5)
    val a = maxProfitTwoOptimized(input1)
    println(a)
}