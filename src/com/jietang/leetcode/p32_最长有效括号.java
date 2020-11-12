package com.jietang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ((()()))
 * <p>
 * while循环
 * 1.获取第一个()的位置 k
 * 2.移除 s[k] s[k+1] cur_max ++2
 * 3.如果 s[k] s[k+1]  == ()  继续移除cur_max++2  如果 s[k-1] s[k]  == () 继续移除 cur_max ++2  k-1
 * 4.其他重新获取记录k的位置m，重新获取k
 */
public class p32_最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()))())("));
    }

    public static int longestValidParentheses(String s) {
        Integer max = 0, cur_max = 0, k = -1;  //历史最大长度 //当前最大长度 //当前位置k
        List<Integer> last_k = new ArrayList<>();
        List<Integer> last_max = new ArrayList<>();
        while (s.length() > 1) {
            if (!s.contains("()")) {
                break;
            }
            if (k == -1) {
                k = s.indexOf("()");
            }
            if (s.charAt(k) == '(' && s.charAt(k + 1) == ')') {
                s = s.replaceFirst("\\(\\)", "");
                cur_max = cur_max + 2;
            } else if (k > 0 && s.charAt(k - 1) == '(' && s.charAt(k) == ')') {
                s = s.replaceFirst("\\(\\)", "");
                cur_max = cur_max + 2;
                k--;
            } else {
                last_max.add(cur_max) ;
                max = max > cur_max ? max : cur_max;
                cur_max = 0;
                last_k.add(k);
                k = -1;
            }
            if (last_k.contains(k)) {
                cur_max = cur_max + last_max.get(last_k.indexOf(k));
                last_max.remove(last_k.indexOf(k));
                last_k.remove(k);
            }
        }
        return max > cur_max ? max : cur_max;
    }
}
