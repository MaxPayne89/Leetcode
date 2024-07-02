package org.practice.array

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var possibleFlowers = 0
    flowerbed.forEachIndexed { index, num ->
        if (num == 0) {
            val emptyLeft = (index == 0 || flowerbed[index - 1] == 0)
            val emptyRight = (index == flowerbed.lastIndex || flowerbed[index+1] == 0)

            if (emptyLeft && emptyRight) {
                possibleFlowers++
                flowerbed[index] = 1
            }
        }
        if (possibleFlowers >= n) return true
    }

    return possibleFlowers >= n
}

fun main() {
    val flowerbed = intArrayOf(1,0,0,0,1)
    val flowerbed1 = intArrayOf(1,0,1,0,1)
    val n = 1
    val n2 = 1
    val result = canPlaceFlowers(flowerbed, n)
    val result2 = canPlaceFlowers(flowerbed1, n2)
    println(result)
    println(result2)
}