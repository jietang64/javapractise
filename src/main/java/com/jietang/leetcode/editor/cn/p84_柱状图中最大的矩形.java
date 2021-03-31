//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组
// 👍 1264 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.Stack;

public class p84_柱状图中最大的矩形 {
    public static void main(String[] args) {
        Solution solution = new p84_柱状图中最大的矩形().new Solution();
        solution.largestRectangleArea(new int[]{2,1,2});
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestRectangleArea_on2(int[] heights) {
            int result = 0;
            for (int i = 0; i < heights.length; i++) {
                int tmpi = heights[i], tmpj = heights[i];
                for (int m = i; m >= 0; m--) {
                    if (heights[m] >= heights[i]) {
                        tmpi = tmpi > heights[i] * (i - m + 1) ? tmpi : heights[i] * (i - m + 1);
                    } else {
                        break;
                    }
                }
                for (int m = i; m < heights.length; m++) {
                    if (heights[m] >= heights[i]) {
                        tmpj = tmpj > heights[i] * (m - i + 1) ? tmpj : heights[i] * (m - i + 1);
                    } else {
                        break;
                    }
                }
                result = result > (tmpi + tmpj - heights[i]) ? result : (tmpi + tmpj - heights[i]);
            }
            return result;
        }

        // 上面那个方法虽然实现了，但是时间复杂度为 O(N2)，
        // 采用栈的方式来实现　栈里面存放index
        ///2 3 5 4 1 3 4 4 3
        ///1 2 3 2 1 3 4 4 3
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int result = heights[0];
            for (int i = 0; i < heights.length; i++) {
                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }
                result = result > heights[i] ? result : heights[i];
                if (heights[stack.peek()] < heights[i]) {
                    //直接插入 计算
                    for (Integer index : stack) {
                        int tmp_result = heights[index] * (i - index + 1);
                        result = result > tmp_result ? result : tmp_result;
                    }
                    stack.push(i);
                } else if (heights[stack.peek()] == heights[i]) {
                    //计算 不插入
                    for (Integer index : stack) {
                        int tmp_result = heights[index] * (i - index + 1);
                        result = result > tmp_result ? result : tmp_result;
                    }
                } else {
                    //将当前值插入栈中，剔除栈内大于该值的元素
                    while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                        Integer pop = stack.pop();
                        if (stack.size() == 0 || heights[stack.peek()] <= heights[i]) {
                            heights[pop] = heights[i];
                            stack.push(pop);
                            break;
                        }
                    }
                    for (Integer index : stack) {
                        int tmp_result = heights[index] * (i - index + 1);
                        result = result > tmp_result ? result : tmp_result;
                    }
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


