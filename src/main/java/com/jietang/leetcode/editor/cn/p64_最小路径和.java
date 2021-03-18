//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划
// 👍 816 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class p64_最小路径和 {
    public static void main(String[] args) {
        Solution solution = new p64_最小路径和().new Solution();
        solution.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            Map<String, Integer> map = new HashMap<>();
            map.put(String.format("%d-%d", grid.length - 1, grid[0].length - 1), grid[grid.length - 1][grid[0].length - 1]);
            cycle(grid, grid.length - 1, grid[0].length - 1, map);
            return map.get("0-0");
        }

        private void cycle(int[][] grid, int m, int n, Map<String, Integer> map) {

            for (int i = m - 1; i >= 0; i--) {
                int sum1 = map.containsKey(String.format("%d-%d", i + 1, n)) ? map.get(String.format("%d-%d", i + 1, n)) : Integer.MAX_VALUE;
                int sum2 = map.containsKey(String.format("%d-%d", i, n + 1)) ? map.get(String.format("%d-%d", i, n + 1)) : Integer.MAX_VALUE;
                map.put(String.format("%d-%d", i, n), sum1 < sum2 ? sum1 + grid[i][n] : sum2 + grid[i][n]);
            }
            for (int i = n - 1; i >= 0; i--) {
                int sum1 = map.containsKey(String.format("%d-%d", m, i + 1)) ? map.get(String.format("%d-%d", m, i + 1)) : Integer.MAX_VALUE;
                int sum2 = map.containsKey(String.format("%d-%d", m + 1, i)) ? map.get(String.format("%d-%d", m + 1, i)) : Integer.MAX_VALUE;
                map.put(String.format("%d-%d", m, i), sum1 < sum2 ? sum1 + grid[m][i] : sum2 + grid[m][i]);
            }
            if (m == 0 && n == 0) {
                return;
            }
            m = m > 0 ? m - 1 : 0;
            n = n > 0 ? n - 1 : 0;
            int sum1 = map.containsKey(String.format("%d-%d", m, n + 1)) ? map.get(String.format("%d-%d", m, n + 1)) : Integer.MAX_VALUE;
            int sum2 = map.containsKey(String.format("%d-%d", m + 1, n)) ? map.get(String.format("%d-%d", m + 1, n)) : Integer.MAX_VALUE;
            map.put(String.format("%d-%d", m, n), sum1 < sum2 ? sum1 + grid[m][n] : sum2 + grid[m][n]);
            cycle(grid, m, n, map);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


