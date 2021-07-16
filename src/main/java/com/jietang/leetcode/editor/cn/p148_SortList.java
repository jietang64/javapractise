//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 链表 双指针 分治 排序 归并排序
// 👍 1217 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

import java.util.Arrays;
import java.util.Objects;

public class p148_SortList {
    public static void main(String[] args) {
        Solution solution = new p148_SortList().new Solution();
        solution.sortList(ListNode.ArrayToListNode(new int[]{-1, 5, 3, 4, 0}));
        System.out.println();
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
        public ListNode sortList(ListNode head) {
            return split(head);
        }

        public ListNode split(ListNode arr) {
            if (arr == null || arr.next == null) {
                return arr;
            }
            ListNode pre = arr;
            ListNode fast = arr.next;
            while (fast.next != null && fast.next.next != null) {
                pre = pre.next;
                fast = fast.next.next;
            }
            ListNode end = pre.next;
            pre.next = null;
            return merge(split(arr), split(end));
        }

        public ListNode merge(ListNode a, ListNode b) {
            ListNode result = new ListNode();
            if (a == null && b == null) {
                return null;
            } else if (a == null || (a != null && b != null && a.val > b.val)) {
                result.val = b.val;
                b = b.next;
            } else if (b == null || (a != null && b != null && a.val <= b.val)) {
                result.val = a.val;
                a = a.next;
            }
            ListNode tmp = result;
            while (a != null && b != null) {
                if (a.val > b.val) {
                    tmp.next = new ListNode(b.val);
                    b = b.next;
                } else {
                    tmp.next = new ListNode(a.val);
                    a = a.next;
                }
                tmp = tmp.next;
            }
            while (a != null) {
                tmp.next = new ListNode(a.val);
                a = a.next;
                tmp = tmp.next;
            }

            while (b != null) {
                tmp.next = new ListNode(b.val);
                b = b.next;
                tmp = tmp.next;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


