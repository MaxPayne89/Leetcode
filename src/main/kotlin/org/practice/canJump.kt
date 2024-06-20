package org.practice

enum class Index {
    GOOD,
    BAD,
    UNKNOWN
}

fun canJump(nums: IntArray): Boolean {
    memo = Array(nums.size) { _ -> Index.UNKNOWN}
    memo[nums.lastIndex] = Index.GOOD
    return canJumpFromPosition(0, nums)
}

private var memo: Array<Index> = arrayOf()

private fun canJumpFromPosition(position: Int, nums: IntArray ): Boolean {
    if (memo[position] != Index.UNKNOWN) {
        return memo[position] == Index.GOOD
    }

    val furthestPossibleJump = minOf(position + nums[position], nums.lastIndex)
    for (i in position+1..furthestPossibleJump) {
        if (canJumpFromPosition(i, nums)) {
            memo[i] = Index.GOOD
            return true
        }
    }

    memo[position] = Index.BAD
    return false
}

fun canJumpTwo(nums: IntArray): Boolean {
    val memo = Array(nums.size) { _ -> Index.UNKNOWN}
    memo[nums.lastIndex] = Index.GOOD

    for (i in nums.lastIndex-1 downTo 0) {
        val furthestPossibleJump = minOf(i + nums[i], nums.lastIndex)
        for (j in i+1..furthestPossibleJump) {
            if (memo[j] == Index.GOOD) {
                memo[i] = Index.GOOD
                break
            }
        }
    }

    return memo[0] == Index.GOOD
}

fun canJumpGreedy(nums: IntArray): Boolean {
    var lastPosition = nums.lastIndex
    for (i in nums.lastIndex downTo 0) {
        if (i + nums[i] >= lastPosition) {
            lastPosition = i
        }
    }
    return lastPosition == 0
}

fun main() {
    val input1 = intArrayOf(9, 4, 2, 1, 0, 2, 0)
    val a = canJumpGreedy(input1)
    println(a)
}