package org.practice.array

private val mappy = mutableMapOf<Int, Int>()

fun maxOperations(nums: IntArray, k: Int): Int {
    nums.forEach { num ->
        mappy[k - num] = mappy.getOrDefault(k - num, 0) + 1
    }

    var counter = 0
    nums.forEach { num ->
        if (num == k - num) {
            if (mappy.contains(num) && mappy[num]!! >= 2) {
                mappy[num] = mappy[num]!! - 2
                counter++
            }
        } else if((mappy.contains(k - num) && mappy[k-num]!! > 0) && (mappy.contains(num) && mappy[num]!! > 0)) {
            mappy[k-num] = mappy[k-num]!! - 1
            mappy[num] = mappy[num]!! - 1
            counter++
        }
    }

    return counter
}

fun maxOpOpti(nums: IntArray, k: Int): Int {
    var counter = 0

    nums.forEach { num ->
        val complement = k - num
        if (mappy.getOrDefault(complement,0) > 0) {
            counter++
            mappy[complement] = mappy[complement]!! - 1
        } else {
            mappy[num] = mappy.getOrDefault(num, 0) + 1
        }
    }

    return counter
}

fun main() {
//    println(maxOperations(intArrayOf(1, 2, 3, 4), 5)) // 2
    println(maxOpOpti(intArrayOf(3, 1, 3, 4, 3), 6)) // 1
}