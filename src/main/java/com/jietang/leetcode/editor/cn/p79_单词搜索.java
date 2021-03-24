//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','E','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 840 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class p79_单词搜索 {
    public static void main(String[] args) {
        Solution solution = new p79_单词搜索().new Solution();
        System.out.println(solution.exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "ABCESEEEFS"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    set.add(board[i][j]);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                if(!set.contains(word.charAt(i))){
                    return false;
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        Set<String> used = new HashSet<>();
                        used.add(i + "-" + j);
                        boolean b = exist2(board, i, j, word, 0, used);
                        if (b) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean exist2(char[][] board, int i, int j, String word, int index, Set<String> used) {
            System.out.print("(" + i + "," + j + ")" + board[i][j] + "->");
            int current_index = index + 1;
            Set<String> current_used = new HashSet<>(used);
            if (current_index >= word.length()) {
                return true;
            }
            // 1. 往上
            if (i > 0) {
                int m = i - 1;
                int n = j;
                if (board[m][n] == word.charAt(current_index) && !current_used.contains(m + "-" + n)) {
                    current_used.add(m + "-" + n);
                    boolean b = exist2(board, m, n, word, current_index, current_used);
                    if (b) {
                        return true;
                    }
                    current_used.remove(m + "-" + n);
                }
            }
            //往下
            if (j > 0) {
                int m = i;
                int n = j - 1;
                if (board[m][n] == word.charAt(current_index) && !current_used.contains(m + "-" + n)) {
                    current_used.add(m + "-" + n);
                    boolean b = exist2(board, m, n, word, current_index, current_used);
                    if (b) {
                        return true;
                    }
                    current_used.remove(m + "-" + n);
                }
            }
            //往上
            if (i < board.length - 1) {
                int m = i + 1;
                int n = j;
                if (board[m][n] == word.charAt(current_index) && !current_used.contains(m + "-" + n)) {
                    current_used.add(m + "-" + n);
                    boolean b = exist2(board, m, n, word, current_index, current_used);
                    if (b) {
                        return true;
                    }
                    current_used.remove(m + "-" + n);
                }
            }
            //往右
            if (j < board[0].length - 1) {
                int m = i;
                int n = j + 1;
                if (board[m][n] == word.charAt(current_index) && !current_used.contains(m + "-" + n)) {
                    current_used.add(m + "-" + n);
                    boolean b = exist2(board, m, n, word, current_index, current_used);
                    if (b) {
                        return true;
                    }
                    current_used.remove(m + "-" + n);
                }
            }
            //
            System.out.println("重新换条路");
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


