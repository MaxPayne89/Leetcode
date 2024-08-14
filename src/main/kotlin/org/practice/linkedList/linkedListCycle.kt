package org.practice.linkedList

import org.practice.ListNode

fun hasCycle(head: ListNode?): Boolean {
    var slow: ListNode? = head
    var fast: ListNode? = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (fast == slow) return true
    }
    return false
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
//    head.next?.next = ListNode(0)
//    head.next?.next?.next = ListNode(-4)
    head.next?.next = head
    println(hasCycle(head)) // true
}