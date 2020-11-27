package com.jietang.leetcode;

public class p11_盛最多水的容器 {

    public static void main(String[] args) {
    }
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = area > max ? area : max;
            }
        }
        return max;
    }
}
