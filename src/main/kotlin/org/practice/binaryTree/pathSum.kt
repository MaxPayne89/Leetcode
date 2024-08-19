package org.practice.binaryTree

import org.practice.TreeNode

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }

    if (root.left == null && root.right == null) {
        return targetSum - root.`val` == 0
    }

    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
//    root.right = TreeNode(8)
//    root.left?.left = TreeNode(11)
//    root.left?.left?.left = TreeNode(7)
//    root.left?.left?.right = TreeNode(2)
//    root.right?.left = TreeNode(13)
//    root.right?.right = TreeNode(4)
//    root.right?.right?.right = TreeNode(1)
    println(hasPathSum(root, 1)) // true
}