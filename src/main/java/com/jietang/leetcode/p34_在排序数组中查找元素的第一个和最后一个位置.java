package com.jietang.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * @author: jietang
 * @create: 2020/11/26-4:52 下午
 **/

public class p34_在排序数组中查找元素的第一个和最后一个位置 {

    @ParameterizedTest
    @MethodSource("testCase")
    void searchRangeTest(int[] nums, int target) {
        searchRange(nums, target);
    }

    public int[] searchRange(int[] nums, int target) {
        // 二分查找 找到第一个 target
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1; //开始结束游标
        int first = -1, second = -1; //返回结果
        int temp_end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            //mid < target 往后查找（不包含 mid） mid >= target 往前查找（=的话 包含当前，>不包含）
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                end = mid;
            } else {
                end = mid - 1;
                temp_end = mid - 1;
            }
        }
        if (nums[start] != target) {
            return new int[]{-1, -1};
        } else {
            first = start;
        }
        end = temp_end;
        while (start < end) {
            int mid = (end + start) / 2 + (end + start) % 2;
            //mid < target 往后查找（不包含 mid） mid >= target 往前查找（=的话 包含当前，>不包含）
            if (nums[mid] == target) {
                if (start == mid) {
                    break;
                }
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        second = start;
        return new int[]{first, second};
    }

    static Stream<Arguments> testCase() {
        return Stream.of(Arguments.arguments(new int[]{1}, 1),
                Arguments.arguments(new int[]{4, 4}, 4));
    }
}
