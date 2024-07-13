package org.practice.sort

import org.practice.ListNode



fun insertionSortList(head: ListNode?): ListNode? {
    val dummy = ListNode(Int.MIN_VALUE)
    var currentNode = head
    while (currentNode != null) {
        var previousNode = dummy

        while (previousNode.next != null && previousNode.next!!.`val` <= currentNode.`val`) {
            previousNode = previousNode.next!!
        }

        val next = currentNode.next

        currentNode.next = previousNode.next
        previousNode.next = currentNode

        currentNode = next
    }
    return dummy.next
}

fun main() {
    val head = ListNode(4)
    head.next = ListNode(2)
    head.next?.next = ListNode(1)
    head.next?.next?.next = ListNode(3)
    val result = insertionSortList(head)
    println(result)
}