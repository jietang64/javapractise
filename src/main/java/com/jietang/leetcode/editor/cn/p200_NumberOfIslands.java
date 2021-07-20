//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 1235 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new p200_NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            Set<String> readed = new HashSet<>();
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int k = 0; k < grid[i].length; k++) {
                    if (readed.contains(i + "_" + k)) {
                        continue;
                    }
                    readed.add(i + "_" + k);
                    if (grid[i][k] == '0') {
                        continue;
                    }
                    result++;
                    findDeep(grid, readed, i, k);
                }
            }
            return result;
        }

        private void findDeep(char[][] grid, Set<String> readed, int i, int k) {
            if (i > 0 && !readed.contains(i - 1 + "_" + k)) {
                readed.add(i - 1 + "_" + k);
                if (grid[i - 1][k] == '1') {
                    findDeep(grid, readed, i - 1, k);
                }
            }
            if (i < grid.length - 1 && !readed.contains(i + 1 + "_" + k)) {
                readed.add(i + 1 + "_" + k);
                if (grid[i + 1][k] == '1') {
                    findDeep(grid, readed, i + 1, k);
                }

            }
            if (k > 0 && !readed.contains(i + "_" + (k - 1))) {
                readed.add(i + "_" + (k - 1));
                if (grid[i][k - 1] == '1') {
                    findDeep(grid, readed, i, k - 1);
                }
            }
            if (k < grid[i].length - 1 && !readed.contains(i + "_" + (k + 1))) {
                readed.add(i + "_" + (k + 1));
                if (grid[i][k + 1] == '1') {
                    findDeep(grid, readed, i, k + 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


