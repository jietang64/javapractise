package com.jietang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class p1_两数之和 {
    public  void main() {
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException();
    }

//runtime:3 ms
//memory:39 MB
}
