package com.jietang.leetcode.editor.cn;

public class p8_字符串转换整数 {

    public static void main(String[] args) {
    }
    public int myAtoi(String str) {
        str = str.trim();
        int res = 0;
        int type = 1;
        if (str.length() > 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
            type = str.charAt(0) == '-' ? -1 : 1;
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            boolean isNum = str.charAt(i) == '0' || str.charAt(i) == '1'
                    || str.charAt(i) == '2' || str.charAt(i) == '3'
                    || str.charAt(i) == '4' || str.charAt(i) == '5'
                    || str.charAt(i) == '6' || str.charAt(i) == '7'
                    || str.charAt(i) == '8' || str.charAt(i) == '9';
            if (!isNum) {
                return res * type;
            }
            int m = Integer.parseInt(str.substring(i, i + 1));
            if (type == 1 && res > ((Integer.MAX_VALUE - m) / 10)) {
                return Integer.MAX_VALUE;
            }
            if (type == -1 && res > -((Integer.MIN_VALUE + m) / 10)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + m;
        }
        return res * type;
    }
}
