package com.jietang.algorithm;

/**
 * 插入排序
 * 核心思想：将数组分为两部分，一部分是已排列的，一部分未排列，将未排列的元素插入到合适的位置
 * 和选择排序不同，插入排序不涉及到交换，类似于窗口移动，大于目标的数据都往后挪一位
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 12, -1, 3};
        System.out.println(InsertSort(arr));
    }

    private static int[] InsertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // i 前面是已排列的数组
            int j = i;
            int target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
        return arr;
    }
}
