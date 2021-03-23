//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 1070 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p78_子集 {
    public static void main(String[] args) {
        Solution solution = new p78_子集().new Solution();
        solution.subsets(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            add(list, nums, 0, new ArrayList<Integer>());
            return list;
        }

        private void add(List<List<Integer>> list, int[] nums, int i, List<Integer> integers) {
            List<Integer> new1 = new ArrayList<>(integers);
            new1.add(nums[i]);
            List<Integer> new2 = new ArrayList<>(integers);
            if (i == nums.length - 1) {
                list.add(new1);
                list.add(new2);
                return;
            }
            int newi = i + 1;
            add(list, nums, newi, new1);
            add(list, nums, newi, new2);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


