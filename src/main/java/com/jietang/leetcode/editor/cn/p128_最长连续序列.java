//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Related Topics 并查集 数组 哈希表
// 👍 815 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p128_最长连续序列 {
    public static void main(String[] args) {
        Solution solution = new p128_最长连续序列().new Solution();
        solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> used_index = new HashSet();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            int result = 0;
            for (Integer key : map.keySet()) {
                if (!used_index.contains(map.get(key))) {
                    int current = 1;
                    used_index.add(map.get(key));
                    int big_bro = key + 1;
                    int lil_bro = key - 1;
                    while (map.containsKey(big_bro)) {
                        used_index.add(map.get(big_bro));
                        current++;
                        big_bro++;
                    }
                    while (map.containsKey(lil_bro)) {
                        used_index.add(map.get(lil_bro));
                        current++;
                        lil_bro--;
                    }
                    result = Math.max(result, current);
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


