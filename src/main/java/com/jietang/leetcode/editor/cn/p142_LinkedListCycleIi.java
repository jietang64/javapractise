//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
// 说明：不允许修改给定的链表。
//
// 进阶：
//
//
// 你是否可以使用 O(1) 空间解决此题？
//
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围在范围 [0, 104] 内
// -105 <= Node.val <= 105
// pos 的值为 -1 或者链表中的一个有效索引
//
// Related Topics 哈希表 链表 双指针
// 👍 1060 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

public class p142_LinkedListCycleIi {
    public static void main(String[] args) {
        // -2 --> -1 --> 1 --> 2 --> 3 --> 4 --> 5
        //              ⬆ <------------------- ⬇
        ListNode round_end = new ListNode(6);
        ListNode round = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, round_end)))));
        round_end.next = round;
        ListNode line_end = new ListNode(-1);
        ListNode line = new ListNode(-5, new ListNode(-4,
                new ListNode(-3, new ListNode(-2, line_end))));
        line_end.next = round;
        p142_LinkedListCycleIi.Solution solution = new p142_LinkedListCycleIi().new Solution();
        System.out.println(solution.detectCycle(round).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) return null;
            ListNode slow = head.next, fast = head.next.next;
            while (slow != fast) {
                if (fast.next == null || fast.next.next == null) return null;
                System.out.println(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

}


