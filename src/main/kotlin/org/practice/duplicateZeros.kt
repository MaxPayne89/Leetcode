package org.practice

fun duplicateZeros(arr: IntArray): Unit {
    var i = 0
    while (i < arr.size) {
        if (arr[i] == 0) {
            for (j in arr.lastIndex downTo i+1) {
                arr[j] = arr[j-1]
            }
            i += 2
        } else {
            i++
        }
    }
}

fun duplicateZerosO(arr: IntArray): Unit {
    // Find the number of zeros to be duplicated
    // Stopping when left points beyond the last element in the original array
    // which would be part of the modified array
    var possibleDups = 0
    var length_: Int = arr.size - 1
        var left = 0
        while (left <= length_ - possibleDups) {
            // Count the zeros
            if (arr[left] == 0) {
                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included

                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0
                    length_ -= 1
                    break
                }
                possibleDups++
            }
            left++
        }

    // Start backwards from the last element which would be part of new array.
    val last = length_ - possibleDups


    // Copy zero twice, and non zero once.
    for (i in last downTo 0) {
        if (arr[i] == 0) {
            arr[i + possibleDups] = 0
            possibleDups--
            arr[i + possibleDups] = 0
        } else {
            arr[i + possibleDups] = arr[i]
        }
    }
}

fun main() {
    val input = intArrayOf(1,0,2,3,0,4,5,0)
    duplicateZerosO(input)
    println(input.contentToString())
}