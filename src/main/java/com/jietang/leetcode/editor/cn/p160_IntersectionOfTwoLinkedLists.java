//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
// 如果两个链表没有交点，返回 null 。
//
// 图示两个链表在节点 c1 开始相交：
//
//
//
// 题目数据 保证 整个链式结构中不存在环。
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。
//
//
//
// 示例 1：
//
//
//
//
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, sk
//ipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
// 示例 2：
//
//
//
//
//输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
// 示例 3：
//
//
//
//
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
//
//
//
//
// 提示：
//
//
// listA 中节点数目为 m
// listB 中节点数目为 n
// 0 <= m, n <= 3 * 104
// 1 <= Node.val <= 105
// 0 <= skipA <= m
// 0 <= skipB <= n
// 如果 listA 和 listB 没有交点，intersectVal 为 0
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
//
//
//
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
// Related Topics 哈希表 链表 双指针
// 👍 1262 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

public class p160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode last = new p160_IntersectionOfTwoLinkedLists()
                .new Solution().getIntersectionNode(ListNode.ArrayToListNode(new int[]{0,1, 2, 3, 4, 5}),
                ListNode.ArrayToListNode(new int[]{1, 3, 3, 4, 5}));
        System.out.println(111);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        ListNode result;
        boolean flag = true;

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            while (a.next != null && b.next != null) {
                a = a.next;
                b = b.next;
            }
            ListNode new_a = headA;
            ListNode new_b = headB;
            if (a.next != null) {
                while (a.next != null) {
                    a = a.next;
                    new_a = new_a.next;
                }
            }
            if (b.next != null) {
                while (b.next != null) {
                    b = b.next;
                    new_b = new_b.next;
                }
            }
            getdif(new_a, new_b);
            return result;
        }

        private void getdif(ListNode new_a, ListNode new_b) {
            if (new_a.next != null) {
                getdif(new_a.next, new_b.next);
            }
            if (new_a.hashCode() != new_b.hashCode()) {
                flag = false;
            }
            if (new_a.hashCode() == new_b.hashCode() && flag) {
                result = new_a;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


