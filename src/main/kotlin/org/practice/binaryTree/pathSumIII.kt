package org.practice.binaryTree

import org.practice.TreeNode


fun pathSumThree(root: TreeNode?, targetSum: Int): Int {
    val prefixSumMappy: MutableMap<Long, Int> = mutableMapOf()
    prefixSumMappy[0] = 1
    var result = 0
    fun dfs(root: TreeNode?, k: Int, prefixSum: Long) {
        if (root == null) {
            return
        }

        val currentPrefixSum = prefixSum + root.`val`
        val diff = currentPrefixSum - k
        result += prefixSumMappy.getOrDefault(diff, 0)
        prefixSumMappy[currentPrefixSum] = 1 + prefixSumMappy.getOrDefault(currentPrefixSum, 0)

        dfs(root.left, k, currentPrefixSum)
        dfs(root.right, k, currentPrefixSum)

        prefixSumMappy[currentPrefixSum] = prefixSumMappy.getOrDefault(currentPrefixSum, 0) - 1
    }
    dfs(root, targetSum, 0)
    return result
}

//private fun preorder()

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(2)
    root.right?.right = TreeNode(11)
    root.left?.left?.left = TreeNode(3)
    root.left?.left?.right = TreeNode(-2)
    root.left?.right?.right = TreeNode(1)
    println(pathSumThree(root, 8))
}