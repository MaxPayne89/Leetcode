package org.practice.setAndHashMap

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
//    val map1 = mutableMapOf<Int, Boolean>()
//    val map2 = mutableMapOf<Int, Boolean>()

//    nums2.forEach {
//        map2[it] = true
//    }

    val nums2Set = nums2.toSet()
    val nums1Set = nums1.toSet()

    nums1Set.minus(nums2Set)

//    nums1.forEach {
//        map1[it] = true
//    }

//    val l1 = nums1.distinct().filterNot { map2[it] == true }
//    val l2 = nums2.distinct().filterNot { map1[it] == true }

    return listOf(nums1Set.minus(nums2Set).toList(), nums2Set.minus(nums1Set).toList())
}

fun main() {
    val nums1 = intArrayOf(1,2,3,3)
    val nums2 = intArrayOf(1,1,2,2)
    val result = findDifference(nums1, nums2)
    println(result)
}