//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1903 👎 0

package com.jietang.leetcode.editor.cn;

import java.util.Stack;

public class p20_有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '[' || charAt == '{' || charAt == '(') {
                stack.push(charAt);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            if (charAt == ']' && (char) stack.pop() != '[') {
                return false;
            }
            if (charAt == '}' && (char) stack.pop() != '{') {
                return false;
            }
            if (charAt == ')' && (char) stack.pop() != '(') {
                return false;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
