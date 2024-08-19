package org.practice.binaryTreeDFS

import org.practice.TreeNode

fun goodNodes(root: TreeNode?): Int {
    return dfs(root, root!!.`val`)
}

private fun dfs(node: TreeNode?, maxSoFar: Int): Int {
    if (node == null) {
        return 0
    }
    if (node.left == null && node.right == null) {
        return if (node.`val` >= maxSoFar) 1 else 0
    }
    return if (node.`val` >= maxSoFar) {
        1 + dfs(node.left, node.`val`) + dfs(node.right, node.`val`)
    } else {
        dfs(node.left,maxSoFar) + dfs(node.right, maxSoFar)
    }
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left?.left = TreeNode(3)
    root.right?.left = TreeNode(1)
    root.right?.right = TreeNode(5)
    println(goodNodes(root))
}