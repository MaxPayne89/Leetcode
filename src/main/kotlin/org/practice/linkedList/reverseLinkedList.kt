package org.practice.linkedList

import org.practice.ListNode

fun reverseList(head: ListNode?): ListNode? {
    var previousNode: ListNode? = null
    var currentNode = head
    while (currentNode != null) {
        val nextNode = currentNode.next
        currentNode.next = previousNode
        previousNode = currentNode
        currentNode = nextNode
    }

    return previousNode
}

fun reverseListRecursively(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val reversedSublist = reverseListRecursively(head.next)
    head.next!!.next = head
    head.next = null

    return reversedSublist
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    val result = reverseListRecursively(head)
    println(result)
}