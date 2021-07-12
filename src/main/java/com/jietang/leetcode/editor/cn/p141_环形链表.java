//给定一个链表，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。
//
//
//
// 进阶：
//
// 你能用 O(1)（即，常量）内存解决此问题吗？
//
//
//
// 示例 1：
//
//
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 104]
// -105 <= Node.val <= 105
// pos 为 -1 或者链表中的一个 有效索引 。
//
// Related Topics 哈希表 链表 双指针
// 👍 1125 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class p141_环形链表 {
    public static void main(String[] args) {
        Solution solution = new p141_环形链表().new Solution();
        ListNode end = new ListNode(3);
        ListNode whole = new ListNode(1, new ListNode(2, end));
        end.next = whole;
        System.out.println(solution.hasCycle(whole));
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
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            return recursion(head, new HashSet<>());
        }

        public boolean recursion(ListNode head, Set<Integer> set) {
            if (set.contains(head.hashCode())) {
                return true;
            }
            set.add(head.hashCode());
            if (head.next != null) {
                return recursion(head.next, set);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


