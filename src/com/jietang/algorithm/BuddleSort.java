package com.jietang.algorithm;

/**
 * 冒泡排序
 * 核心思想：
 * 1. 两两比较相邻的元素，如果arr[k] > arr[k+1] ，则交换位置，这样一次循环结束后，最后一个元素肯定是最大的
 * 2. 去除最后一个元素，对剩下的元素执行1
 * 时间复杂度：O(n²)
 * 空间复杂度: O(1)
 * 稳定性：稳定
 */
public class BuddleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 12, -1, 3};
        System.out.println(buddleSort(arr));
    }

    public static int[] buddleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = 0; k < arr.length - 1 - i; k++) {
                if (arr[k] > arr[k + 1]) {
                    int tmp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
