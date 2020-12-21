package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p15_三数之和 {

    public static void main(String[] args) {
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int k = 0; k < nums.length - 1 - i; k++) {
                if (nums[k] > nums[k + 1]) {
                    int tmp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = tmp;
                }
            }
        }
        i:
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            k:
            for (int k = i + 1; k < nums.length - 1; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                if (nums[i] + nums[k] > 0) {
                    continue i;
                }
                for (int m = nums.length - 1; m > k; m--) {
                    if (nums[i] + nums[k] + nums[m] < 0) {
                        continue k;
                    }
                    if (nums[i] + nums[k] + nums[m] == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[m]);
                        list.add(nums[k]);
                        res.add(list);
                        continue k;
                    }
                }
            }
        }
        return res;
    }
}
