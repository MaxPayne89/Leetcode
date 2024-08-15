package org.practice.linkedList

import org.practice.ListNode

fun detectCycle(head: ListNode?): ListNode? {
    val mappy = mutableMapOf<ListNode, Boolean>()

    var currentNode = head
    while (currentNode != null) {
        if (mappy.containsKey(currentNode)) {
            return currentNode
        } else {
            mappy[currentNode] = true
        }
        currentNode = currentNode.next
    }

    return null
}

fun detectCycleTortoiseAndHare(head: ListNode?): ListNode? {

    // Initialize tortoise and hare pointers
    var tortoise = head
    var hare = head


    // Move tortoise one step and hare two steps
    while (hare?.next != null) {
        tortoise = tortoise!!.next
        hare = hare.next!!.next

        // Check if the hare meets the tortoise
        if (tortoise === hare) {
            break
        }
    }


    // Check if there is no cycle
    if (hare?.next == null) {
        return null
    }


    // Reset either tortoise or hare pointer to the head
    hare = head


    // Move both pointers one step until they meet again
    while (tortoise !== hare) {
        tortoise = tortoise!!.next
        hare = hare!!.next
    }


    // Return the node where the cycle begins
    return tortoise
}

fun main() {
    val head = ListNode(3)
    head.next = ListNode(2)
    head.next?.next = ListNode(0)
    head.next?.next?.next = ListNode(-4)
    head.next?.next?.next?.next = head.next
    println(detectCycle(head)) // 2
}