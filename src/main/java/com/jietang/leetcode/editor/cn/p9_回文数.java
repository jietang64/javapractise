package com.jietang.leetcode.editor.cn;

public class p9_回文数 {

    public static void main(String[] args) {
    }
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        int k = 10;
        int size = 2;
        while (x / k >= 10) {
            size++;
            k = k * 10;
        }
        while (size > 1) {
            if (x / (int) Math.pow(10, size - 1) != x % 10) {
                return false;
            }
            x = x % (int) Math.pow(10, size - 1);
            x = x / 10;
            if (x == 0) {
                return true;
            }
            size = size - 2;
        }
        return true;
    }
}
