package com.jietang.leetcode;

//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics 数组
// 👍 686 👎 0

// 1.找到 p(n-1) > p(n)的数据
// 2.找到 p(n) 到 p(max)中 大于p(n-1)的最小数
// 3.交换 p(n-1)和大于p(n-1)的最小数
// 4.将p(n)-p(max)正序排列
// TODO 思路没问题，后续考虑用while循环 简化代码

import java.util.Arrays;

public class p31_下一个排列 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1};
        nextPermutation(ints);
        System.out.println(Arrays.toString(ints));

    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int index = nums.length - 1;
        int min = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] - nums[index] > 0 && (min == -1 || nums[i] - nums[index] < nums[min] - nums[index])) {
                min = i;
            }
        }
        if (min != -1) {
            int tmp = nums[min];
            nums[min] = nums[index];
            nums[index] = tmp;
        }
        if (index == nums.length - 1) {
            index = -1;
        }
        for (int i = 0; i < nums.length + index; i++) {
            for (int k = index + 1; k < nums.length - 1 - i; k++) {
                if (nums[k] > nums[k + 1]) {
                    int tmp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = tmp;
                }
            }
        }
    }
}
