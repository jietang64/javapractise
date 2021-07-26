//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [
// ['1','0','1','0','0'],
// ['1','0','1','1','1'],
// ['1','1','1','1','1']
//,['1','0','0','1','0']]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [['0','1'],['1','0']]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [['0']]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 数组 动态规划 矩阵
// 👍 819 👎 0


package com.jietang.leetcode.editor.cn;

public class p221_MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new p221_MaximalSquare().new Solution();
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int result = 0;
            if (matrix.length == 0 || matrix[0].length == 0) return result;
            int[][] size = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        if (i > 0 && j > 0 && size[i][j - 1] > 0 && size[i - 1][j] > 0 && size[i - 1][j - 1] > 0) {
                            size[i][j] = Math.min(size[i][j - 1],
                                    Math.min(size[i - 1][j - 1], size[i - 1][j])) + 1;
                        } else {
                            size[i][j] = 1;
                        }
                        result = result > size[i][j] ? result : size[i][j];
                    } else {
                        size[i][j] = 0;
                    }
                }
            }
            return result * result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


