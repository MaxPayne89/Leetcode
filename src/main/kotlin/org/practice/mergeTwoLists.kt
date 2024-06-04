package org.practice

class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    return list1?.let { nnl1 ->
        list2?.let {  nnl2 ->
            return  when {
                nnl1.`val` < nnl2.`val` -> {
                    val ln = ListNode(nnl1.`val`)
                    ln.next = mergeTwoLists(list1.next, list2)
                    ln
                }
                nnl1.`val` > nnl2.`val` -> {
                    val ln = ListNode(nnl2.`val`)
                    ln.next = mergeTwoLists(list1, list2.next)
                    ln
                }
                else -> {
                    val ln = ListNode(nnl1.`val`)
                    ln.next = mergeTwoLists(list1.next, list2)
                    ln
                }
            }
        } ?: run {
            val ln = ListNode(nnl1.`val`)
            ln.next = mergeTwoLists(list1.next, list2)
            ln
        }
    } ?: list2?.let {
        val ln = ListNode(it.`val`)
        ln.next = mergeTwoLists(list1, list2.next)
        ln
    }
}

fun main() {
    val a= ListNode(`val` = 1)
    val b = ListNode(2)
    val c = ListNode(4)
    a.next = b
    b.next = c

    val d= ListNode(`val` = 1)
    val e = ListNode(3)
    val f = ListNode(4)
    d.next = e
    e.next = f

    val g = mergeTwoLists(a,d)!!
    println(g.`val`)
    val h = g.next!!
    println(h.`val`)
    val i = h.next!!
    println(i.`val`)
    val j = i.next!!
    println(j.`val`)
}