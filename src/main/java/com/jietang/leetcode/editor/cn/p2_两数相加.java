package com.jietang.leetcode.editor.cn;

import com.jietang.entity.ListNode;

public class p2_两数相加 {

    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return AddNode(new ListNode(0), l1, l2, 0);
    }

    public static ListNode AddNode(ListNode result, ListNode l1, ListNode l2, int flag) {
        int l = l1.val + l2.val + flag;
        flag = 0;
        if (l >= 10) {
            l = l - 10;
            flag = 1;
        }
        result.val = l;
        if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || flag == 1) {
            l1 = (l1 != null && l1.next != null) ? l1.next : new ListNode(0);
            l2 = (l2 != null && l2.next != null) ? l2.next : new ListNode(0);
            result.next = AddNode(new ListNode(0), l1, l2, flag);
        }
        return result;
    }

}


