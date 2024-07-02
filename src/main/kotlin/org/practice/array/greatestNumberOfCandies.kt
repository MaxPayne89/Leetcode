package org.practice.array

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val maxNumOfCandy = candies.max()
    return candies.map { num ->
        num + extraCandies >= maxNumOfCandy
    }
}

fun main() {
    val candies = intArrayOf(2,3,5,1,3)
    val extraCandies = 3
    val result = kidsWithCandies(candies, extraCandies)
    println(result)
}