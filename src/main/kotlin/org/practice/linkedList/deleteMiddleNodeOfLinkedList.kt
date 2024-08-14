package org.practice.linkedList

import org.practice.ListNode
import kotlin.math.floor

fun deleteMiddle(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return null
    }
    var size = 0
    var currentNode = head
    while (currentNode != null) {
        size++
        currentNode = currentNode.next
    }
    val middle = floor(size / 2.0).toInt()

    val dummy = ListNode(0)
    dummy.next = head

    currentNode = dummy
    for (i in 0 until middle) {
        currentNode = currentNode?.next
    }
    val previousNode = currentNode!!
    val nextNode = previousNode.next?.next
    previousNode.next = nextNode

    return head
}

fun deleteMiddleTwoP(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return null
    }

    var slow = head
    var fast = head.next?.next

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    slow?.next = slow?.next?.next
    return head
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
//    head.next?.next?.next?.next = ListNode(1)
//    head.next?.next?.next?.next?.next = ListNode(2)
//    head.next?.next?.next?.next?.next?.next = ListNode(6)
    val result = deleteMiddle(head)
    println(result)
}