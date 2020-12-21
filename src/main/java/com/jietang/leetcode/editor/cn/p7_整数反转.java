package com.jietang.leetcode.editor.cn;

public class p7_整数反转 {

    public static void main(String[] args) {
    }

    public int reverse(int x) {
        int res = 0;
        int max = (int) (Math.pow(2, 31) - 1);
        int min = -(int) (Math.pow(2, 31));
        while (x != 0) {
            if (res > 0 && res > ((max - (x % 10)) / 10)) {
                return 0;
            }
            if (res < 0 && res < ((min - (x % 10)) / 10)) {
                return 0;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        return res;
    }
}
