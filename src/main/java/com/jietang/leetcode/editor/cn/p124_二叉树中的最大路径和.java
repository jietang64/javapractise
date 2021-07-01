//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中
// 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。
//
// 路径和 是路径中各节点值的总和。
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//
// 示例 2：
//
//
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
//
//
//      -10
//    /   \
//  9       20
//         / \
//        15  7
//
// 提示：
//
//
// 树中节点数目范围是 [1, 3 * 104]
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 递归
// 👍 1082 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;
import com.jietang.tools.TreeOperation;

public class p124_二叉树中的最大路径和 {
    public static void main(String[] args) {
        Solution solution = new p124_二叉树中的最大路径和().new Solution();
        solution.maxPathSum(TreeNode.listToTree("[-2,null,-3]"));
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
        // 分析
        // 1. 中序遍历 左右中
        // 2. 最后一个父节点 包含左中右
        //  (1) 如果左或者右 < 0，都直接剪掉
        //  (3) 左和右都>0 计算左中右的和 比较 max(左中右)
        //  (2) 左或右>0 保留max(左中，右中)

        public int maxPathSum(TreeNode root) {
            if(root == null){
                return 0;
            }
            int result = root.val;
            result = cycle(root, result);
            return result;
        }

        public int cycle(TreeNode root, int result) {
            if (root.left != null) {
                result = cycle(root.left, result);
            }
            if (root.right != null) {
                result = cycle(root.right, result);
            }
            int leftvalue = root.left != null && root.left.val > 0 ? root.left.val : 0;
            int rightvalue = root.right != null && root.right.val > 0 ? root.right.val : 0;
            result = result < leftvalue + rightvalue + root.val ? leftvalue + rightvalue + root.val : result;
            root.val = Math.max(root.val + leftvalue, root.val + rightvalue);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


