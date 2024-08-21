package org.practice.binaryTree

import org.practice.TreeNode
import kotlin.math.max

private var maxZigZagPath = 0

fun longestZigZag(root: TreeNode?): Int {
    maxZigZag(root, Direction.LEFT,0)
    maxZigZag(root, Direction.RIGHT,0)
    return maxZigZagPath
}

enum class Direction {
    LEFT,
    RIGHT
}

private fun maxZigZag(node: TreeNode?, direction: Direction, steps: Int) {
    if (node == null) {
        return
    }
    maxZigZagPath = max(maxZigZagPath, steps)

    return when (direction) {
        Direction.LEFT -> {
            maxZigZag(node.right, Direction.RIGHT, steps + 1)
            maxZigZag(node.left, Direction.LEFT, 1)
        }
        Direction.RIGHT -> {
            maxZigZag(node.left, Direction.LEFT, steps + 1)
            maxZigZag(node.right, Direction.RIGHT, 1)

        }
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right?.left = TreeNode(5)
    root.right?.right = TreeNode(6)
    root.right?.left?.right = TreeNode(7)
    root.right?.right?.right = TreeNode(8)
    println(longestZigZag(root)) // 3
}