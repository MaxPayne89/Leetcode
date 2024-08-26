package org.practice.binaryTree

import org.practice.TreeNode

fun maxLevelSum(root: TreeNode?): Int {
    var maxSum = Int.MIN_VALUE
    var minLevel = 1
    var level = 1
    var nodes = mutableListOf<TreeNode>()

    root?.let { nodes.add(it) }

    while (nodes.isNotEmpty()) {
        val nextLevel = mutableListOf<TreeNode>()
        var levelSum = 0

        for (node in nodes) {
            levelSum += node.`val`
            node.left?.let { nextLevel.add(it) }
            node.right?.let { nextLevel.add(it) }
        }
        if (levelSum > maxSum) {
            maxSum = levelSum
            minLevel = level
        }
        level++
        nodes = nextLevel
    }

    return minLevel
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(7)
    root.right = TreeNode(0)
    root.left?.left = TreeNode(7)
    root.left?.right = TreeNode(-8)
    println(maxLevelSum(root)) // 2
}