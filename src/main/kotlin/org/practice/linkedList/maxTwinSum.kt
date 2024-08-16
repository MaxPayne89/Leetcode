package org.practice.linkedList

import org.practice.ListNode
import java.util.*
import kotlin.math.max

fun pairSum(head: ListNode?): Int {
//    val mappy = mutableMapOf<Int, Int>()
    val listy = mutableListOf<Int>()
    var n = 0
    var currentNode: ListNode? = head
    while (currentNode != null) {
//        mappy[n] = currentNode.`val`
        listy.add(currentNode.`val`)
        currentNode = currentNode.next
        n++
    }

    var maxTwinSum = Int.MIN_VALUE

//    for (i in 0 until n) {
//        maxTwinSum = max(maxTwinSum, listy[i] + listy[n-1-i])
//    }
    var i = 0
    var j = listy.lastIndex
    while (i < j) {
        maxTwinSum = max(maxTwinSum, listy[i] + listy[j])
        i++
        j--
    }
    return maxTwinSum
}

fun pairSumWithStack(head: ListNode?): Int {
    var current = head
    val st = Stack<Int>()

    while (current != null) {
        st.push(current.`val`)
        current = current.next
    }

    current = head
    val size = st.size
    var count = 1
    var maximumSum = 0
    while (count <= size / 2) {
        maximumSum = max(maximumSum, current!!.`val` + st.peek())
        current = current.next
        st.pop()
        count++
    }

    return maximumSum
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(6)
    val result = pairSumWithStack(head)
    println(result)
}