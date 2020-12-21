package com.jietang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class p3_无重复字符的最长子串 {

    public static void main(String[] args) {
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 0, j = 0;
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsValue(s.charAt(i))) {
                map.put(i, s.charAt(i));
                res = res > (i - j + 1) ? res : (i - j + 1);
            } else {
                while (j < i && map.containsValue(s.charAt(i))) {
                    map.remove(j);
                    j++;
                }
                map.put(i, s.charAt(i));
            }
        }
        return res;
    }
}
