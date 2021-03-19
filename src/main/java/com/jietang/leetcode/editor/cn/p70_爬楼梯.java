//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1542 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class p70_爬楼梯 {
    public static void main(String[] args) {
        Solution solution = new p70_爬楼梯().new Solution();
        System.out.println(solution.climbStairs(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            //终点往前 计算，记录每个点到终点的距离

            if (n <= 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int a = 1, b = 2;
            for (int i = n - 3; i >= 0; i--) {
                int m = b;
                b = a + b;
                a = m;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


