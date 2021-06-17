//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树  顺序相同。
//
//
//
//
// 示例 1：
//          1
//        /    \
//       2      3
//     /  \    /  \
//    4   5   6    7
//输入：root = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 树 深度优先搜索
// 👍 824 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;
import com.jietang.tools.TreeOperation;

public class p114_二叉树展开为链表 {
    public static void main(String[] args) {
        Solution solution = new p114_二叉树展开为链表().new Solution();
        TreeNode treeNode = TreeNode.listToTree("[1,2,3,4,5,6,7]");
        System.out.println(TreeOperation.show(treeNode));
        solution.flatten(treeNode);
        System.out.println(TreeOperation.show(treeNode));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.right != null) {
                flatten(root.right);
            }
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    //最后一个左子节点
                    root.left.right = root.right;
                    root.right = root.left;
                    root.left = null;
                } else {
                    flatten(root.left);
                }
            }
            if (root.left != null) {
                flattenLeft(root.left, root.right);
                root.right = root.left;
                root.left = null;
            }
        }

        public void flattenLeft(TreeNode root, TreeNode right) {
            if (root.right == null) {
                root.right = right;
            } else {
                flattenLeft(root.right, right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


