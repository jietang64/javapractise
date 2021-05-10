//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
//
//
// 示例 2：
//
//
//输入：matrix = []
//输出：0
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
// 示例 4：
//
//
//输入：matrix = [["1"]]
//输出：1
//
//
// 示例 5：
//
//
//输入：matrix = [["0","0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// rows == matrix.length
// cols == matrix[0].length
// 0 <= row, cols <= 200
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 栈 数组 哈希表 动态规划
// 👍 867 👎 0


package com.jietang.leetcode.editor.cn;

public class p85_最大矩形 {
    public static void main(String[] args) {
        Solution solution = new p85_最大矩形().new Solution();
        solution.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}});


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*

     */
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int[][] ele_length = new int[matrix.length][matrix[0].length];
            int result = 0;
            for (int i = 0; i < matrix.length; i++) {
                int num1_length = 0;
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        num1_length++;
                        ele_length[i][j] = num1_length;
                        int m = i;
                        int min_width = num1_length;
                        while (m >= 0) {
                            min_width = Math.min(min_width, ele_length[m][j]);
                            result = Math.max(min_width * (i - m + 1), result);
                            m--;
                        }
                    } else {
                        num1_length = 0;
                        ele_length[i][j] = num1_length;
                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


