package org.practice.array

fun replaceElements(arr: IntArray): IntArray {
    var maxSoFar = arr[arr.lastIndex]
    for (i in arr.lastIndex downTo 0) {
        if (i == arr.lastIndex) {
            arr[i] = -1
            continue
        }
        if (arr[i] > maxSoFar) {
            val newMax = arr[i]
            arr[i] = maxSoFar
            maxSoFar = newMax
        } else {
            arr[i] = maxSoFar
        }
    }
    return arr
}

fun main() {
    val input = intArrayOf(17,18,5,4,6,1)
    val a = replaceElements(input)
    println(a.contentToString())
}