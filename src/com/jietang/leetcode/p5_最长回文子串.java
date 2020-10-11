package com.jietang.leetcode;

public class p5_最长回文子串 {

    public static void main(String[] args) {
    }
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            while ((i - k >= 0) && (i + k <= s.length() - 1) && (s.charAt(i - k) == s.charAt(i + k))) {
                if (res.length() < k * 2 + 1) {
                    res = s.substring(i - k, i + k + 1);
                }
                k++;
            }
            k = 0;
            while ((i - k >= 0) && (i + k <= s.length() - 2) && (s.charAt(i - k) == s.charAt(i + k + 1))) {
                if (res.length() < (k + 1) * 2) {
                    res = s.substring(i - k, i + k + 2);
                }
                k++;
            }
        }
        return res;
    }
}
