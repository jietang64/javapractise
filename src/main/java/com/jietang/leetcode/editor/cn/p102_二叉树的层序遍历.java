//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 890 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class p102_二叉树的层序遍历 {
    public static void main(String[] args) {
        Solution solution = new p102_二叉树的层序遍历().new Solution();
        solution.levelOrder(TreeNode.listToTree("[3,9,20,null,null,15,7]"));
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<TreeNode> tmp = new ArrayList<>();
            tmp.add(root);
            cycle(tmp, result);
            return result;
        }

        private void cycle(List<TreeNode> tmp, List<List<Integer>> result) {
            List<Integer> single = new ArrayList<>();
            List<TreeNode> newtmp = new ArrayList<>();
            tmp.forEach(node -> {
                single.add(node.val);
                if (node.left != null) {
                    newtmp.add(node.left);
                }
                if (node.right != null) {
                    newtmp.add(node.right);
                }
            });
            result.add(single);
            if(newtmp.size()>0){
                cycle(newtmp, result);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


