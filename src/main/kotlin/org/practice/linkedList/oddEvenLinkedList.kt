package org.practice.linkedList

import org.practice.ListNode

fun oddEvenList(head: ListNode?): ListNode? {
    var odd = head
    val oddHead = head
    var even = head?.next
    val evenHead = even

    var nextOdd: ListNode?
    var nextEven: ListNode?

    var lastOdd: ListNode? = null
    while (odd != null || even != null) {
        if (odd != null) {
            nextOdd = odd.next?.next
            odd.next = nextOdd
            lastOdd = odd
            odd = nextOdd
        }

        if (even != null) {
            nextEven = even.next?.next
            even.next = nextEven
            even = nextEven
        }
    }
    lastOdd?.next = evenHead

    return oddHead
}

fun oddEvenListOptimized(head: ListNode?): ListNode? {
    if (head == null) return null
    var odd = head
    var even = head.next
    val evenHead = even
    while (even?.next != null) {
        odd!!.next = even.next
        odd = odd.next
        even.next = odd!!.next
        even = even.next
    }
    odd!!.next = evenHead
    return head
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(6)
    val result = oddEvenList(head)
    println(result)
}