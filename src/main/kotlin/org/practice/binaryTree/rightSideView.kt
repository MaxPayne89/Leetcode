package org.practice.binaryTree

import org.practice.TreeNode

fun rightSideView(root: TreeNode?): List<Int> {
    val rightSideList = mutableListOf<Int>()
    var currentLevel = mutableListOf<TreeNode>()

    if (root != null) {
        currentLevel.add(root)
    }

    while (currentLevel.isNotEmpty()) {
        rightSideList.add(currentLevel.last().`val`)

        val nextLevel = mutableListOf<TreeNode>()

        for (currentNode in currentLevel) {
            if (currentNode.left != null) {
                nextLevel.add(currentNode.left!!)
            }
            if (currentNode.right != null) {
                nextLevel.add(currentNode.right!!)
            }
        }

        currentLevel = nextLevel
    }

    return rightSideList
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.right = TreeNode(5)
    root.right?.right = TreeNode(4)
    println(rightSideView(root)) // [1, 3, 4]
}