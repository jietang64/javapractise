//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
//前序遍历 preorder = [3,9,11,12,20,15,7]
//中序遍历 inorder = [11,9,12,3,15,20,7]
//
// 返回如下的二叉树：
//
//          3
//        /    \
//       9      20
//     /  \    /  \
//    11   12  15   7
// Related Topics 树 深度优先搜索 数组
// 👍 1074 👎 0

package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p105_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new p105_从前序与中序遍历序列构造二叉树().new Solution();
        solution.buildTree(new int[]{3, 9, 11, 12, 20, 15, 7}, new int[]{11, 9, 12, 3, 15, 20, 7});
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
            List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
            // 传入两个数组 返回 [顶点 A B]
            if (preorder.length == 0) {
                return new TreeNode();
            }
            TreeNode treeNode = cycle(preorderList, inorderList);
            return treeNode;
        }

        public TreeNode cycle(List<Integer> preorderList, List<Integer> inorderList) {
            TreeNode treeNode = new TreeNode();
            int root = preorderList.get(0);
            int first_length = inorderList.indexOf(root);
            List<Integer> leftPreorderList = preorderList.subList(1, first_length + 1);
            List<Integer> rightPreorderList = preorderList.subList(first_length + 1, preorderList.size());

            List<Integer> leftInorderList = inorderList.subList(0, first_length);
            List<Integer> rightInorderList = inorderList.subList(first_length + 1, inorderList.size());
            treeNode.val = root;
            if (leftPreorderList.size() > 0 && leftInorderList.size() > 0) {
                treeNode.left = cycle(leftPreorderList, leftInorderList);
            }
            if (rightInorderList.size() > 0 && rightPreorderList.size() > 0) {
                treeNode.right = cycle(rightPreorderList, rightInorderList);
            }
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


