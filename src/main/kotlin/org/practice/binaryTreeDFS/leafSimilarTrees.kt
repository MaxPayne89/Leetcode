package org.practice.binaryTreeDFS

import org.practice.TreeNode

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val leaves1 = mutableListOf<Int>()
    val leaves2 = mutableListOf<Int>()
    dfsLeaves(root1, leaves1)
    dfsLeaves(root2, leaves2)
    return leaves1 == leaves2
}

private fun dfsLeaves(node: TreeNode?, leafList: MutableList<Int>) {
    if (node != null) {
        if (node.left == null && node.right == null) leafList.add(node.`val`)
        dfsLeaves(node.left, leafList)
        dfsLeaves(node.right, leafList)
    }
}

fun main() {
    val root1 = TreeNode(3)
    root1.left = TreeNode(5)
    root1.right = TreeNode(1)
    root1.left?.left = TreeNode(6)
    root1.left?.right = TreeNode(2)
    root1.left?.right?.left = TreeNode(7)
    root1.left?.right?.right = TreeNode(4)
    root1.right?.left = TreeNode(9)
    root1.right?.right = TreeNode(8)

    val root2 = TreeNode(3)
    root2.left = TreeNode(5)
    root2.right = TreeNode(1)
    root2.left?.left = TreeNode(6)
    root2.left?.right = TreeNode(7)
    root2.right?.left = TreeNode(4)
    root2.right?.right = TreeNode(2)
    root2.right?.right?.left = TreeNode(9)
    root2.right?.right?.right = TreeNode(8)

    val result = leafSimilar(root1, root2)
    println(result)
}