//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组
// 👍 822 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p56_合并区间 {
    public static void main(String[] args) {
        Solution solution = new p56_合并区间().new Solution();
        solution.merge(new int[][]{new int[]{1, 4}, new int[]{4, 5}, new int[]{2, 5}, new int[]{3, 5}, new int[]{0, 5}, new int[]{6, 12}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            //1. 按照第一个数字进行排序
            //2. 遍历数组，如果n+1[0] < n[1] 则合并n和n+1
            for (int i = 0; i < intervals.length - 1; i++) {
                for (int j = i; j < intervals.length; j++) {
                    if (intervals[i][0] > intervals[j][0]) {
                        int[] a = intervals[i];
                        intervals[i] = intervals[j];
                        intervals[j] = a;
                    }
                }
            }
            List<int[]> result = new ArrayList<>();
            result.add(intervals[0]);
            int index = 0;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] <= result.get(index)[1]) {
                    //可以合并
                    result.get(index)[1] = result.get(index)[1] > intervals[i][1] ? result.get(index)[1] : intervals[i][1];
                } else {
                    //需要另起一行
                    index++;
                    result.add(intervals[i]);
                }
            }

            int[][] objects = result.toArray(new int[result.size()][]);
            return objects;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


