package org.practice.binaryTree

import org.practice.TreeNode

private var answer: TreeNode? = null

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    answer = root
    dfs(root, p!!, q!!)
    return answer
}

fun lcaOptimized(root: TreeNode?, p: TreeNode?, q: TreeNode?) : TreeNode? {
    var currentNode = root

    while (currentNode != null) {
        when {
            p!!.`val` > currentNode.`val` && q!!.`val` > currentNode.`val` -> {
                currentNode = currentNode.right
            }
            p.`val` < currentNode.`val` && q!!.`val` < currentNode.`val` -> {
                currentNode = currentNode.left
            }
            else -> {
                return currentNode
            }
        }
    }
    return null
}

private fun dfs(node: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
    if (node == null) {
        return false
    }

    val left = if (dfs(node.left, p, q)) 1 else 0
    val right = if (dfs(node.right, p, q)) 1 else 0
    val mid = if (node == p || node == q) 1 else 0

    if (left + mid + right >= 2) {
        answer = node
    }

    return (left + mid + right >= 1)
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(6)
    root.left?.right = TreeNode(2)
    root.right?.left = TreeNode(0)
    root.right?.right = TreeNode(8)
    root.left?.right?.left = TreeNode(7)
    root.left?.right?.right = TreeNode(4)
    println(lowestCommonAncestor(root, root.left, root.right)?.`val`) // 3
}