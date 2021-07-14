package com.jietang.algorithm;

import java.util.Arrays;

/**
 * @author: jietang
 * @create: 2021/7/14-4:57 下午
 **/

public class MergeSort {
    public static void main(String... args) {
        int[] arr = new int[]{1, 3, 4, 5, 12, -1, 6, 1, 65, -23};
        arr = split(arr);
        System.out.println(arr);
    }

    public static int[] split(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] pre = Arrays.copyOfRange(arr, 0, mid);
        int[] end = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(split(pre), split(end));
    }

    public static int[] merge(int[] a, int[] b) {
        int a_index = 0, b_index = 0;
        int index = 0;
        int[] result = new int[a.length + b.length];
        while (a_index < a.length && b_index < b.length) {
            if (a[a_index] > b[b_index]) {
                result[index++] = b[b_index++];
            } else {
                result[index++] = a[a_index++];
            }
        }
        while (a_index < a.length) result[index++] = a[a_index++];
        while (b_index < b.length) result[index++] = b[b_index++];
        return result;
    }
}
