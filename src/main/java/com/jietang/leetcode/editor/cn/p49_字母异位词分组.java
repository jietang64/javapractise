//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 622 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class p49_字母异位词分组 {
    public static void main(String[] args) {
        Solution solution = new p49_字母异位词分组().new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"ddddddddddg", "dgggggggggg"});
        System.out.println(1);
    }

    /**
     * 将每个字符串的每个单词的数量 当作一个map的key即可
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<HashMap, List<String>> result = new HashMap<>();
            for (String str : strs) {
                HashMap<Character, Integer> aaa = new HashMap<>();
                for (int i = 0; i < str.length(); i++) {
                    if (!aaa.containsKey(str.charAt(i))) {
                        aaa.put(str.charAt(i), 0);
                    }
                    aaa.put(str.charAt(i), aaa.get(str.charAt(i)) + 1);
                }
                List<String> strings = new ArrayList<>();
                if (result.containsKey(aaa)) {
                    strings = result.get(aaa);
                }
                strings.add(str);
                result.put(aaa, strings);
            }
            return result.entrySet().stream().map(i -> i.getValue()).collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


