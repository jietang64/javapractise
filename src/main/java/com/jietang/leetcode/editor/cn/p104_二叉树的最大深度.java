//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 递归
// 👍 895 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;

public class p104_二叉树的最大深度 {
    public static void main(String[] args) {
        Solution solution = new p104_二叉树的最大深度().new Solution();
        solution.maxDepth(TreeNode.listToTree("[3,9,20,null,null,15,7]"));
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = cycle(root, 0, 0);
            return result;
        }

        private int cycle(TreeNode root, int currentResult, int maxResult) {
            maxResult = currentResult + 1 > maxResult ? currentResult + 1 : maxResult;
            if (root.left != null) {
                maxResult = cycle(root.left, currentResult + 1, maxResult);
            }
            if (root.right != null) {
                maxResult = cycle(root.right, currentResult + 1, maxResult);
            }
            return maxResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


