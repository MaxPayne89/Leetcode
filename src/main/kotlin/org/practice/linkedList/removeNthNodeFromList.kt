package org.practice.linkedList

import org.practice.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummyNode: ListNode = ListNode(0)
    dummyNode.next = head
    var leftPointer: ListNode? = dummyNode
    var rightPointer: ListNode? = dummyNode
    for (i in 0..n) {
        rightPointer = rightPointer?.next
    }
    while (rightPointer != null) {
        leftPointer = leftPointer?.next
        rightPointer = rightPointer.next
    }

    leftPointer?.next = leftPointer?.next?.next
    return dummyNode.next
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    val n = 2
    val result = removeNthFromEnd(head, n)
    var curr = result
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}