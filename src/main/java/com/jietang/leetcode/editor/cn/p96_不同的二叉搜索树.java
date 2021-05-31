//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：5
// 【1 null 2 null 3】【1 null 3 2】【2 3 1】【3 1 null null 2】 【3 2 null 1】
//   1            1        2         3         3
//    2             3    1   3     1          2
//     3          2                  2       1
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 19
//
// Related Topics 树 动态规划
// 👍 1164 👎 0


package com.jietang.leetcode.editor.cn;

public class p96_不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new p96_不同的二叉搜索树().new Solution();
        solution.numTrees(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            if (n == 0) return 0;
            else if (n == 1) return 1;
            else if (n == 2) return 2;
            int[] result = new int[n + 1];
            result[0] = 1;
            result[1] = 1;
            result[2] = 2;
            // p[n] = p[0]*p[n-1] +...+p[n-1]*p[0] 递归计算即可
            // todo 可继续优化，算出一半的即可
            for (int i = 3; i <= n; i++) {
                int tmpsum = 0;
                int k = i - 1;
                while (k >= 0) {
                    tmpsum += result[k] * result[i - 1 - k];
                    k--;
                }
                result[i] = tmpsum;
            }
            return result[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


