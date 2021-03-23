//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//
//
//输入：nums = [2,0,1]
//输出：[0,1,2]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[0]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2
//
//
//
//
// 进阶：
//
//
// 你可以不使用代码库中的排序函数来解决这道题吗？
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针
// 👍 822 👎 0
//0 0 0 1  1 2 2 2

package com.jietang.leetcode.editor.cn;

public class p75_颜色分类 {
    public static void main(String[] args) {
        Solution solution = new p75_颜色分类().new Solution();
        solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int index1 = -1, index2 = -1; //第一个1的位置 第一个2的位置
            for (int z = 0; z < nums.length; z++) {
                switch (nums[z]) {
                    case 0:
                        if (index1 != -1) {
                            nums[z] = 1;
                            nums[index1] = 0;
                            index1++;
                        }
                        if (index2 != -1) {
                            int tmp = nums[z];
                            nums[z] = 2;
                            nums[index2] = tmp;
                            index2++;
                        }
                        break;
                    case 1:
                        if (index2 != -1) {
                            int tmp = nums[z];
                            nums[z] = 2;
                            nums[index2] = tmp;
                            index2++;
                        }
                        if (index1 == -1) {
                            if (index2 != -1) {
                                index1 = index2 - 1;
                            } else {
                                index1 = z;
                            }
                        }
                        break;
                    case 2:
                        if (index2 == -1) {
                            index2 = z;
                        }
                        break;
                }
            }
            System.out.println(nums);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


