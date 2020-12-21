package com.jietang.leetcode.editor.cn;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"(()","(())"})
    void longestValidParentheses(String s) {
        Integer max = 0, cur_max = 0, k = s.indexOf("()");  //历史最大长度 //当前最大长度 //当前位置k
        List<Integer> last_k = new ArrayList<>();
        List<Integer> last_max = new ArrayList<>();
        while (s.length() > 1 && s.contains("()")) {
            if (s.charAt(k) == '(' && s.charAt(k + 1) == ')') {
                s = s.replaceFirst("\\(\\)", "");
                cur_max = cur_max + 2;
            } else if (k > 0 && s.charAt(k - 1) == '(' && s.charAt(k) == ')') {
                s = s.replaceFirst("\\(\\)", "");
                cur_max = cur_max + 2;
                k--;
            } else {
                //当前是(( 或者 )) 或者 )( ，保存当前点位置和长度
                last_max.add(cur_max);
                last_k.add(k);
                max = max > cur_max ? max : cur_max;
                cur_max = 0;
                k = s.indexOf("()");
            }
            if (last_k.contains(k)) {
                //当前点和上次保存点相邻，将上次的长度加上去
                cur_max = cur_max + last_max.get(last_k.indexOf(k));
                last_max.remove(last_k.indexOf(k));
                last_k.remove(k);
            }
        }
        System.out.println(max > cur_max ? max : cur_max);
        //return max > cur_max ? max : cur_max;
    }
}
