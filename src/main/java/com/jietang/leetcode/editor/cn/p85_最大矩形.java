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

/*

{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}
        {{'1', '0'}}


 */
public class p85_最大矩形 {
    public static void main(String[] args) {
        Solution solution = new p85_最大矩形().new Solution();
        solution.maximalRectangle(new char[][]{
                {'1', '0', '1'},
                {'1', '0', '1'},
                {'1', '1', '1'},
                {'1', '0', '0'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
        从右下往左上遍历，记录该点到右边、下边最大的边长
     */
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int sideLength = Math.min(matrix.length, matrix[0].length);
            for (int startindex = 0; startindex < sideLength; startindex++) {
                int height = startindex < matrix[0].length - 1 ? startindex : matrix[0].length - 1;
                int width = startindex < matrix.length - 1 ? startindex : matrix.length - 1;
                for (int i = startindex; i <  matrix[0].length; i++) {
                    System.out.println(height + "," + i + "=" + matrix[height][i]);
                }
                for (int i = startindex + 1; i < matrix.length; i++) {
                    System.out.println(i + "," + width + "=" + matrix[i][width]);
                }

            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


