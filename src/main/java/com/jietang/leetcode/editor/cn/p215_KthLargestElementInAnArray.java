//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104
// 4 3 5 6
// 6 3 5 _
// 6 _ 5 3
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
// 👍 1184 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.Arrays;

public class p215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new p215_KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{6, 2, 1, 3, 5, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{6, 2, 1, 3, 5, 4}, 3));
        System.out.println(solution.findKthLargest(new int[]{6, 2, 1, 3, 5, 4}, 4));
        System.out.println(solution.findKthLargest(new int[]{6, 2, 1, 3, 5, 4}, 5));
        System.out.println(solution.findKthLargest(new int[]{6, 2, 1, 3, 5, 4}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //采用选择排序 使前面有k-1个元素
        public int findKthLargest(int[] nums, int k) {
            int base = nums[nums.length - 1], start = 0, end = nums.length - 1;
            while (start < end) {
                while (nums[start] >= base && start < end) start++;
                while (nums[end] <= base && start < end) end--;
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
            nums[nums.length - 1] = nums[end];
            nums[end] = base;
            if (k == start + 1) {
                // 6 5 4 3 2 1
                return nums[start];
            } else if (k < start + 1) {
                return findKthLargest(Arrays.copyOfRange(nums, 0, start), k);
            } else {
                return findKthLargest(Arrays.copyOfRange(nums, start + 1, nums.length), k - start - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


