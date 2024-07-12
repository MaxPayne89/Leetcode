package org.practice.binaryTreeDFS

import org.practice.TreeNode
import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + max(maxDepth(root.left),maxDepth(root.right))
}

fun maxDepthIterative(root: TreeNode?): Int {
    if (root == null) return 0

    var maxDepth = 0
    val stack = ArrayDeque<Pair<TreeNode, Int>>()
    stack.addLast(Pair(root, 1))

    while (stack.isNotEmpty()) {
        val (node, depth) = stack.removeLast()
        maxDepth = max(maxDepth, depth)

        node.left?.let { stack.addLast(Pair(it, depth + 1)) }
        node.right?.let { stack.addLast(Pair(it, depth + 1)) }
    }

    return maxDepth
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    val result = maxDepth(root)
    println(result)
}