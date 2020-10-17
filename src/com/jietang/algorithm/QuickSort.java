package com.jietang.algorithm;

/**
 * 快速排序
 * 1.以第一个数为基准数
 * 2.使用双指针 left = 1 , right = n-1
 * 2.1 right右到左移动, 当arr[right] > key 时，交换arr[left] arr[right]
 * 2.2 left左到右移动，当arr[left] < key 时，暂停移动
 * 2.3 重复 2.1，2.2，当left = right = k 时 交换 arr[k] 和 arr[0] ,
 * 因为是先移动right 再移动left,所以当right找到的时候，arr[left] 一定是小于key的
 * 但是如果所有的数据都大于key，也就是k  = n - 1,此时不用交换
 * 3.递归
 * 3.1 left = left, right = k - 1
 * 3.2 left = k + 1, right = right
 */
public class QuickSort {
    public static void main(String... args) {
        int[] arr = new int[]{1, 3, 4, 5, 12, -1, 6, 1, 65, -23};
        QuickSort(0, arr.length - 1, arr);
        System.out.println(arr);
    }

    public static void QuickSort(int left, int right, int[] arr) {
        int key = arr[left];
        int origin_left = left;
        int origin_right = right;
        left++;
        bigone:
        while (left < right) {
            while (arr[right] > key) {
                right--;
                if (left == right) {
                    continue bigone;
                }
            }
            while (arr[left] < key) {
                left++;
                if (left == right) {
                    continue bigone;
                }
            }
            int tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
        }
        int tem = arr[origin_left];
        arr[origin_left] = arr[right];
        arr[right] = tem;
        if (right - origin_left > 1) {
            QuickSort(origin_left, right - 1, arr);
        }
        if (origin_right - right > 0) {
            QuickSort(right, origin_right, arr);
        }
    }
}
