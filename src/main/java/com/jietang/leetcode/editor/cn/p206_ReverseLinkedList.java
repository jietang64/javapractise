//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 递归 链表
// 👍 1849 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

public class p206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new p206_ReverseLinkedList().new Solution();
        Long start = System.currentTimeMillis();
        ListNode node = solution.reverseList(ListNode.ArrayToListNode(new int[]{1, 3, 4, 5, 6, 7}));
        System.out.println("总耗时" + (System.currentTimeMillis() - start));
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
        public ListNode reverseList(ListNode head) {
            ListNode tmp = null;
            ListNode point = head;
            while (point != null) {
                ListNode curr = new ListNode(point.val);
                curr.next = tmp;
                tmp = curr;
                point = point.next;
            }
            return tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


