//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出
// ，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。
//
//
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//
// 示例 2：
//
//
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；
// 并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//
//
// 提示：
//
//
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 875 👎 0


package com.jietang.leetcode.editor.cn;

import java.util.*;

public class p207_CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new p207_CourseSchedule().new Solution();
        System.out.println(solution.canFinish(6, new int[][]{
                {0, 1},
                {1, 2}, {2, 3}, {3, 0}, {0, 5}}));
    }
   
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> list = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++) {
                Set<Integer> integers;
                if (list.containsKey(prerequisites[i][0])) {
                    integers = list.get(prerequisites[i][0]);
                } else {
                    integers = new HashSet<>();
                }
                integers.add(prerequisites[i][1]);
                list.put(prerequisites[i][0], integers);
            }
            // key 想学的课，value 需要完成的课
            while (!list.isEmpty()) {
                Integer key = list.keySet().iterator().next();
                HashSet<Integer> readed = new HashSet<>();
                boolean result = check(key, list, readed);
                if (!result) {
                    return false;
                }
            }
            return true;
        }

        private boolean check(Integer key, Map<Integer, Set<Integer>> list, HashSet<Integer> readed) {
            if (readed.contains(key)) {
                return false;
            }
            readed.add(key);
            Set<Integer> preCourse = list.get(key);
            Iterator<Integer> iterator = preCourse.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (!list.containsKey(next)) {
                    iterator.remove();
                    continue;
                }
                boolean result = check(next, list, readed);
                if (!result) {
                    return false;
                }
            }
            list.remove(key);
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


