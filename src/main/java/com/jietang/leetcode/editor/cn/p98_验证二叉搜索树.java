//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//     15
//   /    \
//  4      19
//      / \
//    17   20
//      / \
//     16   18
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// 示例 2:
//
// 输入:
//          32
//        /    \
//       26      47
//      / \      / \
//     19 null  null 56
//    / \
//   null 27
// Related Topics 树 深度优先搜索 递归
// 👍 1077 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class p98_验证二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new p98_验证二叉搜索树().new Solution();
        System.out.println(solution.isValidBST(TreeNode.listToTree("[32,26,47,19,null,null,56,null,27]")));
        //System.out.println(solution.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

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
        public boolean isValidBST(TreeNode root) {
            if (root != null) {
                Integer max = null, min = null;
                boolean validBST = isValidBSTWithMaxMin(root, max, min);
                if (!validBST) {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidBSTWithMaxMin(TreeNode node, Integer max, Integer min) {
            if (node.left != null) {
                //  往左走，开始有最大值
                int tmpMax = max == null ? node.val : node.val < max ? node.val : max;
                if (node.left.val < tmpMax && (min == null || node.left.val > min)) {
                    boolean validBST = isValidBSTWithMaxMin(node.left, tmpMax, min);
                    if (!validBST) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (node.right != null) {
                int tmpMin = min == null ? node.val : node.val > min ? node.val : min;
                if (node.right.val > tmpMin && (max == null || node.right.val < max)) {
                    boolean validBST = isValidBSTWithMaxMin(node.right, max, tmpMin);
                    if (!validBST) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


