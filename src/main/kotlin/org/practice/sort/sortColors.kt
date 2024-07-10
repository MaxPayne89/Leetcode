package org.practice.sort

fun sortColors(nums: IntArray): Unit {
    val mappy = mutableMapOf<Int, Int>()
    mappy[0] = 0
    mappy[1] = 0
    mappy[2] = 0

    nums.forEach { num ->
        mappy[num] = mappy.getOrDefault(num, 0) + 1
    }

    for (i in 0 until mappy[0]!!) {
        nums[i] = 0
    }
    for (i in (mappy[0]!!)until (mappy[0]!! + mappy[1]!!)) {
        nums[i] = 1
    }
    for (i in (mappy[0]!! + mappy[1]!!)until (mappy[0]!! + mappy[1]!!+ mappy[2]!!)) {
        nums[i] = 2
    }

}

fun main() {
    val nums = intArrayOf(0)
    sortColors(nums)
    println(nums.contentToString())
}