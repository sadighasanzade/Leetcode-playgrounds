package leetcode.easy

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var arr = IntArray(2)
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (nums[i] + nums[j] == target) {
                    arr = intArrayOf(i, j)
                    break
                }
            }
        }
        return arr.sortedArray()
    }
}