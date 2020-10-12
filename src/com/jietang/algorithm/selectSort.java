package com.jietang.algorithm;

/**
 * 选择排序
 * 核心思想：
 * 每次都从剩下的元素中选取最小的放到前面
 * 时间复杂度：O(n²)
 * 空间复杂度: O(1)
 * 稳定性：稳定
 */
public class selectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 12, -1, 3};
        System.out.println(selectSort(arr));
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
}
