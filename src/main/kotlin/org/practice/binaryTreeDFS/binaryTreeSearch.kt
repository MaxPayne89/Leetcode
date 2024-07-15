package org.practice.binaryTreeDFS

import org.practice.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    var currentNode = root
    while (currentNode != null) {
        (if (`val` > currentNode.`val`) {
            currentNode.right
        } else if (`val` < currentNode.`val`) {
            currentNode.left
        } else {
            return currentNode
        }).also { currentNode = it }
    }
    return null
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    val result = searchBST(root, 2)
    println(result)
}