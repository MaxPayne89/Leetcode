package org.practice.binaryTree

import org.practice.TreeNode


fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) {
        return root
    }

    if (key > root.`val`) {
        root.right = deleteNode(root.right, key)
    } else if (key < root.`val`) {
        root.left = deleteNode(root.left, key)
    } else {
        if (root.left == null) {
            return root.right
        } else if (root.right == null) {
            return root.left
        }

        var currentNode = root.right
        while (currentNode?.left != null) {
            currentNode = currentNode.left
        }

        root.`val` = currentNode!!.`val`
        root.right = deleteNode(root.right, root.`val`)
    }

    return root
}

fun deleteNodeO(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return null


    // delete from the right subtree
    if (key > root.`val`) root.right = deleteNode(root.right, key)
    else if (key < root.`val`) root.left = deleteNode(root.left, key)
    else {
        // the node is a leaf
        if (root.left == null && root.right == null) return null
        else if (root.right != null) {
            root.`val` = findSuccessorNode(root)
            root.right = deleteNode(root.right, root.`val`)
        } else {
            root.`val` = findPredecessorNode(root)
            root.left = deleteNode(root.left, root.`val`)
        }
    }
    return root
}

private fun findSuccessorNode(node: TreeNode): Int {
    var currNode = node.right
    while (currNode?.left != null) {
        currNode = currNode.left
    }
    return currNode!!.`val`
}

private fun findPredecessorNode(node: TreeNode): Int {
    var currNode = node.left
    while (currNode?.right != null) {
        currNode = currNode.right
    }
    return currNode!!.`val`
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right?.right = TreeNode(7)
    println(deleteNode(root, 3)) // [5, 4, 6, 2, null, null, 7]
}