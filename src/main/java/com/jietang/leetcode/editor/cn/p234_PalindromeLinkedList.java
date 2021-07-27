//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针
// 👍 1060 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

public class p234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new p234_PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(
                ListNode.ArrayToListNode(new int[]{1, 2,3,4,3,2,1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode fast = head, end = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                end = end.next;
            }
            //反转end 4 3 2 1 -> 4 1 2 3
            ListNode endParent = end; //4 3 2 1
            end = end.next; // 3 2 1
            ListNode pointer = end; // 3 2 1
            while (pointer.next != null) {
                endParent.next = pointer.next; //endParent =  4 2 1
                pointer.next = pointer.next.next; //pointer =  3 1  end = 3 1
                endParent.next.next = end; // endParent = 4 2 3 1
                end = endParent.next;//end =  2 3 1
            }
            while (true) {
                if (end.val != head.val) {
                    return false;
                }
                if (end.next == null) break;
                end = end.next;
                head = head.next;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


