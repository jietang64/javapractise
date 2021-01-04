//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
// 。。。。。。。。。。。。
// 。。。。。。。例。。。。
// 。。。例。。。例例。例。
// 。例。例例。例例例例例例
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针
// 👍 1882 👎 0
// 1. 从左到右遍历
/**
 * 从左到右遍历
 * 1、寻找第一个 > 0的数字
 * 2、再往后遍历 找到大于等于该数字的第一个数
 */

package com.jietang.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class p42_接雨水 {
    public static void main(String[] args) {
        Solution solution = new p42_接雨水().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int startIndex = 0, endIndex = 0;
            int result = 0;
            start:
            while (startIndex < height.length - 1) {
                // 当开始点 = 0 时 没有办法积水 顺延到下一个
                if (height[startIndex] == 0 || height[startIndex] < height[startIndex + 1]) {
                    startIndex++;
                    continue start;
                }
                endIndex = startIndex + 2;
                int maxIndex = endIndex;
                //移动 endIndex 并记下maxIndex
                while (endIndex < height.length) {
                    if (height[endIndex] >= height[startIndex]) {
                        result += calcute(startIndex, endIndex, height);
                        startIndex = endIndex;
                        continue start;
                    } else {
                        maxIndex = height[maxIndex] < height[endIndex] ? endIndex : maxIndex;
                        endIndex++;
                    }
                }
                result += calcute(startIndex, maxIndex, height);
                startIndex = maxIndex;
                continue start;
            }
            return result;
        }

        private int calcute(int startIndex, int endIndex, int[] height) {
            int result = 0;
            if (startIndex > height.length - 1 || endIndex > height.length - 1) {
                return result;
            }
            int maxSize = height[startIndex] > height[endIndex] ? height[endIndex] : height[startIndex];
            for (int i = startIndex + 1; i < endIndex; i++) {
                int tmp = maxSize - height[i];
                if (tmp > 0) {
                    result += tmp;
                }
            }
            System.out.println(String.format("开始计算大小 开始点=%s 结束点=%s 结果=%s", startIndex, endIndex, result));
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
