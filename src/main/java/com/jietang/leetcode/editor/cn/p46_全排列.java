//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
/**
 *
 */
// Related Topics 回溯算法
// 👍 1061 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p46_全排列 {
    public static void main(String[] args) {
        Solution solution = new p46_全排列().new Solution();
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> req = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            for (int i : nums) {
                req.add(i);
            }
            for (int i = 0; i < req.size(); i++) {
                List<Integer> tmp = new ArrayList<>(req);
                List<Integer> start = new ArrayList<>();
                start.add(req.get(i));
                tmp.remove(i);
                addArr(start, tmp, result);
            }

            return result;
        }

        private void addArr(List<Integer> start, List<Integer> req, List<List<Integer>> result) {
            if (req.size() == 0) {
                result.add(start);
            }
            for (int i = 0; i < req.size(); i++) {
                List<Integer> newreq = new ArrayList<>(req);
                List<Integer> newstart = new ArrayList<>(start);
                newstart.add(req.get(i));
                newreq.remove(i);
                addArr(newstart, newreq, result);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}


