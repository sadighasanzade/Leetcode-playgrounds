package leetcode.hard

import java.util.*

class MedianOfTwoArray {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var firstIterator = 0
        var secondIterator = 0
        val sizeOfFirstArray = nums1.size
        val sizeOfSecondArray = nums2.size
        val result = IntArray(sizeOfFirstArray + sizeOfSecondArray)

        var i = 0
        if(nums1.isEmpty()) {
            return getMedian(nums2)
        }else if(nums2.isEmpty()) {
            return getMedian(nums1)
        }
        while (true) {
            if(firstIterator < sizeOfFirstArray && (secondIterator >= sizeOfSecondArray || nums1[firstIterator] < nums2[secondIterator])) {
                result[i] = nums1[firstIterator]
                firstIterator += 1
            }else if(secondIterator < sizeOfSecondArray && (firstIterator >= sizeOfFirstArray || nums1[firstIterator] > nums2[secondIterator])){
                result[i] = nums2[secondIterator]
                secondIterator += 1

            }else{
                if(sizeOfFirstArray >= firstIterator){
                    result[i] = nums2[secondIterator]
                }else {
                    result[i] = nums1[firstIterator]
                }
                if(firstIterator < sizeOfFirstArray) {
                    firstIterator += 1
                }
                if(secondIterator < sizeOfSecondArray) {
                    secondIterator += 1
                }
            }
            if(secondIterator == sizeOfSecondArray && firstIterator == sizeOfFirstArray) {
                break
            }
            i++
        }
        return getMedian(result.take(i + 1).toIntArray())
    }

    fun getMedian(arr: IntArray): Double {
        if(arr.size %2 == 1) {
            return (arr[(arr.size / 2).toInt()]).toDouble()
        }
        return ((arr[arr.size / 2] + arr[arr.size / 2 - 1]) / 2.0)
    }
}