//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划
// 👍 1044 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p139_单词拆分 {
    public static void main(String[] args) {
        Solution solution = new p139_单词拆分().new Solution();
        System.out.println(solution.wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreakMemory(s, wordDict, new HashSet<>());
        }

        public boolean wordBreakMemory(String s, List<String> wordDict, Set<String> failSet) {
            if (s.length() == 0 || wordDict.contains(s)) return true;
            for (int i = 1; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if (failSet.contains(right)) {
                    continue;
                }
                if (wordDict.contains(left)) {
                    if (wordBreakMemory(right, wordDict,failSet)) {
                        return true;
                    } else {
                        failSet.add(right);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


