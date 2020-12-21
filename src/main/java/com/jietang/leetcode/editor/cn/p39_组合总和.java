//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1：
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2：
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯算法
// 👍 1096 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p39_组合总和 {
    public static void main(String[] args) {
        Solution solution = new p39_组合总和().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            cycle(candidates, target, new ArrayList<>(), 0, result);
            return result;
        }

        /**
         * @param candidates
         * @param target
         * @param list
         * @param index      当前index  1. 加上当前index 2.跳过当前index
         */
        private void cycle(int[] candidates, int target, List<Integer> list, int index, List<List<Integer>> result) {
            if (index == candidates.length) {
                return;
            }
            cycle(candidates, target, list, index + 1, result);
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(candidates[index]);
            int newTarget = target - candidates[index];
            if (newTarget == 0) {
                result.add(list2);
            } else if (newTarget < 0) {
                return;
            } else {
                cycle(candidates, newTarget, list2, index, result);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


