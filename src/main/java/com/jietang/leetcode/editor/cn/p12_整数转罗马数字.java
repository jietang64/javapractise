package com.jietang.leetcode.editor.cn;

public class p12_整数转罗马数字 {

    public static void main(String[] args) {
    }
    public String intToRoman(int num) {
        String[] sign = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        StringBuffer res = new StringBuffer();
        int i = 0;
        while (num > 0) {
            StringBuffer str = new StringBuffer();
            int yu = num % 10;
            if (yu == 9) {
                str.append(sign[i]);
                str.append(sign[i + 2]);
                yu = 0;
            } else if (yu < 9 && yu >= 5) {
                str.append(sign[i + 1]);
                yu = yu - 5;
            }
            if (yu == 4) {
                str.append(sign[i]);
                str.append(sign[i + 1]);
            } else {
                while (yu > 0) {
                    str.append(sign[i]);
                    yu--;
                }
            }
            i = i + 2;
            num = num / 10;
            res.insert(0, str);
        }
        return res.toString();
    }
}
