package org.practice.array

fun checkIfExist(arr: IntArray): Boolean {
    val map = mutableMapOf<Int,Int>()
    arr.forEachIndexed { index, i ->
        map[i] = index
    }
    for (i in arr.indices) {
        if (map.contains(2 * arr[i]) && map[2 * arr[i]] != i) {
            return true
        }
    }

    return false
}

fun main() {
    val input = intArrayOf(4,-7,11,4,18)
    val a = checkIfExist(input)
    println(a)
}