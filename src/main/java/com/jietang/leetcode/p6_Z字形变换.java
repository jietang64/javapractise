package com.jietang.leetcode;

public class p6_Z字形变换 {

    public static void main(String[] args) {
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int more_width = (s.length() % (numRows * 2 - 2)) > numRows ? (s.length() % (numRows * 2 - 2)) - numRows + 1 : 1;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < ((numRows - 1) * (s.length() / (numRows * 2 - 2)) + more_width); k++) {
                int cur_group = k / (numRows - 1);
                if (k % (numRows - 1) == 0) {
                    int s_index = cur_group * (numRows * 2 - 2) + i;
                    if (s_index < s.length()) {
                        res.append(s.charAt(s_index));
                    }
                } else if ((numRows - i - 1) == k % (numRows - 1)) {
                    int group_pos = k % (numRows - 1);
                    int s_index = cur_group * (numRows * 2 - 2) + numRows + group_pos - 1;
                    if (s_index < s.length()) {
                        res.append(s.charAt(s_index));
                    }
                }
            }
        }
        return res.toString();
    }
}
