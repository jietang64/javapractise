package com.jietang.leetcode;

public class p19_删除链表的倒数第N个节点 {

    public static void main(String[] args) {
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }
        return getNoode(head, tmp);
    }
    public static ListNode getNoode(ListNode tmp, ListNode cycle) {
        if (cycle == null) {
            return tmp.next;
        }
        tmp.next = getNoode(tmp.next, cycle.next);
        return tmp;
    }
}
