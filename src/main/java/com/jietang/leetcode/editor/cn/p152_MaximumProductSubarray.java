//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释:子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划
// 👍 1180 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class p152_MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new p152_MaximumProductSubarray().new Solution();
        System.out.println(solution.maxProduct(new int[]{0, -3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int lastPositive = 0;
            int result = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    lastPositive = lastPositive == 0 ? nums[i] : lastPositive * nums[i];
                } else {
                    if (lastPositive != 0) {
                        result = result < lastPositive ? lastPositive : result;
                        list.add(lastPositive);
                    }
                    result = result < nums[i] ? nums[i] : result;
                    lastPositive = 0;
                    list.add(nums[i]);
                }
            }
            if (lastPositive != 0) {
                result = result < lastPositive ? lastPositive : result;
                list.add(lastPositive);
            }
            for (int i = 0; i < nums.length - 1; i++) {
                int total = nums[i];
                int max_total = nums[i];
                for (int k = i + 1; k < nums.length; k++) {
                    total = total * nums[k];
                    max_total = max_total < total ? total : max_total;
                }
                result = result < max_total ? max_total : result;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


