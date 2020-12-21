package com.jietang.leetcode.editor.cn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author: jietang
 * @create: 2020/11/28-3:35 下午
 **/

public class p33_搜索旋转数组 {


    public int search(int[] nums, int target) {
        //1. 判断是在哪个点旋转 正序
        //由于数组是有序的 所以一定会存在 前面一部分 大于后面一部分
        if (nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int switch_index = -1;
        while (start < end) {
            int mid = (start + end) / 2 + (start + end) % 2;
            if (nums[mid - 1] > nums[mid]) {
                switch_index = mid;
                break;
            }
            if (nums[mid] < nums[start]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int[] new_nums = new int[nums.length];
        if (switch_index == -1) {
            new_nums = nums;
        } else {
            for (int i = 0; i < nums.length - switch_index; i++) {
                new_nums[i] = nums[i + switch_index];
            }
            for (int i = 0; i < switch_index; i++) {
                new_nums[i + (nums.length - switch_index)] = nums[i];
            }
        }
        start = 0;
        end = nums.length - 1;
        int target_index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (new_nums[mid] == target) {
                target_index = mid;
                break;
            } else if (new_nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (target_index == -1) {
            return -1;
        }
        if (switch_index == -1) {
            return target_index;
        }
        if ((nums.length - switch_index) > target_index) {
            return switch_index + target_index ;
        } else {
            return target_index - (nums.length - switch_index);
        }
    }


    @ParameterizedTest
    @MethodSource("testCase")
    void searchRangeTest(int[] nums, int target) {
        System.out.println(search(nums, target));
    }

    static Stream<Arguments> testCase() {
        return Stream.of(Arguments.arguments(new int[]{5,1,3},3));
    }
}
