package leetcode.medium

class LongestPalindromic {
    fun longestPalindrome(s: String): String {
        var max = ""
        for (i in s.indices) {
            for (j in i..s.length) {
                val word = s.substring(i, j)
                if (word.equals(word.reversed())) {
                    if (word.length > max.length) {
                        max = word
                    }
                }
            }
        }
        return max
    }
}