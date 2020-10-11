package com.jietang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class p18_四数之和 {

    public static void main(String[] args) {
        // write your code here
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(nums, -11));
    }
    //			测试结果:[[-3,3,2,-2],[-3,3,1,-1],[-3,3,0,0],[-2,3,0,-1],[-2,2,0,0],[-1,1,0,0]]
    //			期望结果:[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int k = 0; k < nums.length - 1 - i; k++) {
                if (nums[k] > nums[k + 1]) {
                    int tmp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = tmp;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        i:
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            k:
            for (int k = i + 1; k < nums.length - 2; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                l:
                for (int l = k + 1; l < nums.length - 1; l++) {
                    if (l > k + 1 && nums[l] == nums[l - 1]) {
                        continue;
                    }
                    for (int m = nums.length - 1; m > l; m--) {
                        if (nums[i] + nums[k] + nums[l] + nums[m] < target) {
                            continue l;
                        }
                        if (nums[i] + nums[k] + nums[l] + nums[m] == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[m]);
                            list.add(nums[l]);
                            list.add(nums[k]);
                            res.add(list);
                            continue l;
                        }
                    }
                }
            }
        }
        return res;
    }
}
