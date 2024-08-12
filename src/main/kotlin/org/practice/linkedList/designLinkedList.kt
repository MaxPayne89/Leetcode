package org.practice.linkedList

class MyLinkedList() {

    private class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    private var head: ListNode = ListNode(0)
    private var size = 0

    fun get(index: Int): Int {
        if (index < 0 || index >= size) {
            return -1
        }
        var curr: ListNode? = head
        for (i in 0 until index + 1) {
            curr = curr!!.next
        }
        return curr!!.`val`
    }

    fun addAtHead(`val`: Int) {
        addAtIndex(0,`val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index > size) {
            return
        }
        val newIndex: Int = if (index < 0) {
            0
        } else {
            index
        }

        ++size

        var pred: ListNode? = head
        for (i in 0 until newIndex) pred = pred!!.next


        val toAdd = ListNode(`val`)
        toAdd.next = pred!!.next
        pred.next = toAdd
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) {
            return
        }

        size--

        var pred: ListNode? = head
        for (i in 0 until index) {
            pred = pred!!.next
        }
        pred!!.next = pred.next!!.next
    }
}

fun main() {
    val linkedList = MyLinkedList()
    linkedList.addAtHead(1)
    linkedList.addAtTail(3)
    linkedList.addAtIndex(1, 2)
    println(linkedList.get(1))
    linkedList.deleteAtIndex(0)
    println(linkedList.get(0))
}