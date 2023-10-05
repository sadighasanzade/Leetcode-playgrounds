package leetcode.medium

public class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isNullOrEmpty()) {
            return 0
        }
        var charArray = s.toCharArray()
        val countList = mutableListOf<Int>()
        for(i in charArray.indices) {
            val charList = mutableListOf<Char>()
            var j = i
            var count = 0
            while(j < charArray.size) {
                if(charList.contains(charArray[j])) {
                    break
                }
                charList.add(charArray[j])
                count += 1
                j += 1
            }
            countList.add(count)
        }
        return countList.max()
    }
}