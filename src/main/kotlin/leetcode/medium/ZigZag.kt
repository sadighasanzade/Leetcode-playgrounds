package leetcode.medium

import java.lang.StringBuilder

class ZigZag {
    fun convert(s: String, numRows: Int): String {
        if(numRows <= 1) {
            return s
        }
        val matrice: MutableList<MutableList<Char>> = mutableListOf()
        val baseIndexes = IntArray(2*numRows - 1)
        for (i in 0 until numRows) {
            matrice.add(i, mutableListOf())
            baseIndexes[i] = i
            if(numRows - 1 != i) {
                baseIndexes[2 * numRows - 2 - i] = i
            }
        }
        var count = 0
        for (char in s) {
            if(count >= baseIndexes.size) {
                count = 1
            }
            val index = baseIndexes[count]
            matrice[index].add(char)
            count ++
        }
        val sb = StringBuilder()
        for(array in matrice) {
            sb.append(String(array.toCharArray()))
        }

        return sb.toString()
    }
}