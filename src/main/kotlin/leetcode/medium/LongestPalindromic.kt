package leetcode.medium

class LongestPalindromic {
    fun longestPalindrome(s: String): String {
        var max = ""
        for (i in s.indices) {
            for (j in (i)..s.length) {
                val word = s.substring(i, j)
                if (isPalindrome(word)) {
                    if (word.length > max.length) {
                        max = word
                    }
                }
            }
        }
        return max
    }

    fun isPalindrome(string: String): Boolean {
        var end = string.length - 1
        if(end <= 0) {
            return true
        }
        for (i in 0..(string.length / 2)) {
            if(string[i] != string[end - i]){
                return false
            }
        }
        return true
    }
}