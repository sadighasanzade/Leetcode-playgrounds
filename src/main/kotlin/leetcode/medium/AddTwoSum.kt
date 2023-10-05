package leetcode.medium;


public class AddTwoSum {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (getSizeOfNode(l1) > getSizeOfNode(l2)) {
            return addTwoNumbers(l2, l1)
        }
        var iterator = l2
        var lowIterator = l1
        var result: ListNode? = null
        var mem = 0
        while (iterator != null) {
            var digit = iterator.`val` + (lowIterator?.`val` ?: 0) + mem
            if (digit >= 10) {
                digit %= 10
                mem = 1
            } else {
                mem = 0
            }
            //insert to result
            if (result == null) {
                result = ListNode(digit)
                if (iterator.next == null && mem != 0) {
                    result?.next = ListNode(mem)
                }
            } else {
                var resIterator = result
                while (resIterator!!.next != null) {
                    resIterator = resIterator.next
                }
                resIterator.next = ListNode(digit)
                resIterator = resIterator.next
                if (iterator.next == null && mem != 0) {
                    resIterator?.next = ListNode(mem)
                }
            }
            iterator = iterator.next
            lowIterator = lowIterator?.next
        }
        return result
    }


    fun getSizeOfNode(node: ListNode?): Int {
        var size = 0
        node?.let {
            size = 1
            var iterator = node.next;
            while (iterator != null) {
                size += 1
                iterator = iterator.next
            }
        }
        return size
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}