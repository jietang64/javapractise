//给定一个 n × n 的二维矩阵表示一个图像。
//
// 将图像顺时针旋转 90 度。
//
// 说明：
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
// 示例 1:
//
// 给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
////  [7,2,1],
////  [4,5,6],
////  [7,8,3]
//
// 示例 2:
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//
// Related Topics 数组
// 👍 745 👎 0


package com.jietang.leetcode.editor.cn;

public class p48_旋转图像 {
    public static void main(String[] args) {
        Solution solution = new p48_旋转图像().new Solution();
        solution.rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * k*k 目标数在 4
         * a[m][n] = a[k-1-n][m]
         */
        public void rotate(int[][] matrix) {
            int size = matrix.length;
            int cycle = size % 2 == 0 ? (size / 2) : (size / 2 + 1);
            int maxtmpm = size / 2;
            for (int tmpm = 0; tmpm < cycle; tmpm++) {
                for (int tmpn = 0; tmpn < maxtmpm; tmpn++) {
                    int m = -1, n = -1;
                    int tmp = matrix[tmpm][tmpn];
                    while (m != tmpm || n != tmpn) {
                        if (m == -1 || n == -1) {
                            m = tmpm;
                            n = tmpn;
                        }
                        matrix[m][n] = matrix[size - 1 - n][m];
                        int changetmp = m;
                        m = size - 1 - n;
                        n = changetmp;
                    }
                    matrix[tmpn][size - tmpm - 1] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


