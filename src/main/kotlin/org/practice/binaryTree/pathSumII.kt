package org.practice.binaryTree

import org.practice.TreeNode

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val allPaths: MutableList<List<Int>> = mutableListOf()
    fun dfs(root: TreeNode?, targetSum: Int, currentPath: List<Int>) {
        if (root == null) {
            return
        }

        if (root.isLeafNode()) {
            if (targetSum - root.`val` == 0) {
                allPaths.add(currentPath + listOf(root.`val`))
            }
        } else {
            dfs(root.left, targetSum - root.`val`, currentPath + listOf(root.`val`))
            dfs(root.right, targetSum - root.`val`, currentPath + listOf(root.`val`))
        }
    }
    dfs(root, targetSum, listOf())
    return allPaths
}

//private fun dfs(root: TreeNode?, targetSum: Int, currentPath: List<Int>) {
//
//}

private fun TreeNode?.isLeafNode() = this?.left == null && this?.right == null

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left?.left = TreeNode(11)
    root.left?.left?.left = TreeNode(7)
    root.left?.left?.right = TreeNode(2)
    root.right?.left = TreeNode(13)
    root.right?.right = TreeNode(4)
    root.right?.right?.right = TreeNode(1)
    root.right?.right?.left = TreeNode(5)
    println(pathSum(root, 22))
}