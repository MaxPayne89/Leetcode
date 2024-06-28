package org.practice.array

fun validMountainArray(arr: IntArray): Boolean {
    if (arr.size < 3) return false
    var i = 0

    while (i < arr.lastIndex && arr[i + 1] > arr[i]) {
            i++
    }
    if (i == 0 || i == arr.lastIndex) return false

    while (i < arr.lastIndex && arr[i + 1] < arr[i] ) {
            i++
    }

    return i == arr.lastIndex
}

fun main() {
    val input = intArrayOf(9,8,7,6,5,4,3,2,1,0)
    val a = validMountainArray(input)
    println(a)
}