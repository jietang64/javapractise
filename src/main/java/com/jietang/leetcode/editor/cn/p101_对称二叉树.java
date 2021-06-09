//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 1402 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;

public class p101_对称二叉树 {
    public static void main(String[] args) {
        Solution solution = new p101_对称二叉树().new Solution();
        solution.isSymmetric(TreeNode.listToTree("[1,2,2,3,4,4,3]"));
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            if (root.left == null || root.right == null) {
                return false;
            }
            boolean result = cycle(root.left, root.right);
            System.out.println(result);
            return result;
        }

        private boolean cycle(TreeNode leftNode, TreeNode rightNode) {
            if (leftNode.val != rightNode.val) {
                return false;
            }
            // 当前值相等，比对子节点的值
            if (leftNode.left != null && rightNode.right != null) {
                boolean cycle = cycle(leftNode.left, rightNode.right);
                if (!cycle) {
                    return false;
                }
            } else if (!(leftNode.left == null && rightNode.right == null)) {
                return false;
            }

            // 当前值相等，比对子节点的值
            if (leftNode.right != null && rightNode.left!= null) {
                boolean cycle = cycle(leftNode.right, rightNode.left);
                if (!cycle) {
                    return false;
                }
            } else if (!(leftNode.right == null && rightNode.left == null)) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


