package com.jietang.leetcode;

public class p55_跳跃游戏 {
    public static void main(String[] args) {
    }
    /**
     * 1. 从后往前查
     * 2. 如果下一个节点可以到达当前节点，则去掉最后一个节点
     * 如果不行 则继续往后取，若所有节点都到达不了，则返回false
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        big:
        for (int i = nums.length - 1; i > 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                if (nums[k] >= (i - k)) {
                    continue big;
                }
            }
            return false;
        }
        return true;
    }
}
