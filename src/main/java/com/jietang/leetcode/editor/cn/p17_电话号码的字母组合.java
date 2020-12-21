package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p17_电话号码的字母组合 {

    public static void main(String[] args) {
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        String[] arr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return res;
        }
        generate(digits, arr, "", res);
        return res;
    }

    private void generate(String digits, String[] arr, String front, List<String> res) {
        int num = Integer.valueOf(String.valueOf(digits.charAt(0)));
        String str = arr[num - 2];
        for (int i = 0; i < str.length(); i++) {
            String format = String.format("%s%s", front, str.charAt(i));
            if (digits.length() == 1) {
                res.add(format);
            } else {
                generate(digits.substring(1), arr, format, res);
            }
        }
    }
}
