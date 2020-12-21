package com.jietang.leetcode.editor.cn;

/*给你一个链表数组，每个链表都已经按升序排列。

 请你将所有链表合并到一个升序链表中，返回合并后的链表。



 示例 1：

 输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6


 示例 2：

 输入：lists = []
输出：[]


 示例 3：

 输入：lists = [[]]
输出：[]




 提示：


 k == lists.length
 0 <= k <= 10^4
 0 <= lists[i].length <= 500
 -10^4 <= lists[i][j] <= 10^4
 lists[i] 按 升序 排列
 lists[i].length 的总和不超过 10^4

 Related Topics 堆 链表 分治算法
 👍 945 👎 0*/


import com.jietang.entity.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p23_合并K个升序链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(6)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        ListNode[] arr = new ListNode[]{};
        mergeKLists(arr);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> collect = Arrays.stream(lists).filter(i -> i != null).collect(Collectors.toList());
        if (collect.size() > 0) {
            return findMinNode(collect);
        } else {
            return null;
        }
    }

    private static ListNode findMinNode(List<ListNode> collect) {
        int min = collect.get(0).val;
        int minIndex = 0;
        ListNode node = new ListNode();
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).val < min) {
                min = collect.get(i).val;
                minIndex = i;
            }
        }
        node.val = min;
        System.out.println(min);
        if (collect.get(minIndex).next != null) {
            collect.set(minIndex, collect.get(minIndex).next);
        } else {
            collect.remove(minIndex);
        }
        if (collect.size() > 0) {
            node.next = findMinNode(collect);
        }
        return node;
    }

}
