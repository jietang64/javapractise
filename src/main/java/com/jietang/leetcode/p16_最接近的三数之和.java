package com.jietang.leetcode;

public class p16_最接近的三数之和 {

    public static void main(String[] args) {
    }
    public int threeSumClosest(int[] nums, int target) {
        int key = 100000;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int k = i + 1; k < nums.length - 1; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                for (int m = k + 1; m < nums.length; m++) {
                    if (Math.abs(nums[i] + nums[k] + nums[m] - target) < Math.abs(key)) {
                        key = nums[i] + nums[k] + nums[m] - target;
                    }
                }
            }
        }
        return key + target;
    }
}
