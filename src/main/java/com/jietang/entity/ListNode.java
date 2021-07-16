package com.jietang.entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode ArrayToListNode(int[] input) {
        ListNode head = new ListNode(input[0]);
        ListNode tmp = head;
        for (int i = 1; i < input.length; i++) {
            tmp.next = new ListNode(input[i]);
            tmp = tmp.next;
        }
        return head;
    }
}
