//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//   1
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
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 942 👎 0


package com.jietang.leetcode.editor.cn;

import com.jietang.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class p94_二叉树的中序遍历 {
    public static void main(String[] args) {
        Solution solution = new p94_二叉树的中序遍历().new Solution();
        solution.inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                getChild(root, result);
            }
            return result;
        }

        public void getChild(TreeNode root, List<Integer> result) {
            if (root.left != null) {
                getChild(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                getChild(root.right, result);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


