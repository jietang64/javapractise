//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划
// 👍 917 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class p62_不同路径 {
    public static void main(String[] args) {
        Solution solution = new p62_不同路径().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //每个元素向下走 向右走都有两条路径，分别从 m-1 出发 和 n-1 出发
        public int uniquePaths(int m, int n) {
            Map<String, Integer> map = new HashMap<>();
            cycle(m - 1, n - 1, map);
            return map.get("0-0");
        }

        private void cycle(int m, int n, Map<String, Integer> map) {
            for (int i = m; i >= 0; i--) {
                int sum1 = map.containsKey(String.format("%d-%d", i + 1, n)) ? map.get(String.format("%d-%d", i + 1, n)) : 0;
                int sum2 = map.containsKey(String.format("%d-%d", i, n + 1)) ? map.get(String.format("%d-%d", i, n + 1)) : 0;
                map.put(String.format("%d-%d", i, n), sum1 + sum2 == 0 ? 1 : sum1 + sum2);
            }
            for (int i = n; i >= 0; i--) {
                int sum1 = map.containsKey(String.format("%d-%d", m, i + 1)) ? map.get(String.format("%d-%d", m, i + 1)) : 0;
                int sum2 = map.containsKey(String.format("%d-%d", m + 1, i)) ? map.get(String.format("%d-%d", m + 1, i)) : 0;
                map.put(String.format("%d-%d", m, i), sum1 + sum2 == 0 ? 1 : sum1 + sum2);
            }
            if (m == 0 && n == 0) {
                return;
            }
            m = m > 0 ? m - 1 : 0;
            n = n > 0 ? n - 1 : 0;
            cycle(m, n, map);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


