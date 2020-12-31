package com.alibaba.cainiao.leetcode;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 * 进阶：
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class LeetCode75 {
    // https://www.acwing.com/video/1418/
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return;
        }

        //  0, 1, and 2 to represent the color red, white, and blue
        // [0, red) 表示红色, [red, white) 表示白色, [blue,)表示蓝色, 左闭区间右开
        int red = 0, white = 0, blue = n - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                // 红色
                swap(nums, white, red);
                white++;
                red++;
            } else if (nums[white] == 2) {
                // 蓝色
                swap(nums, white, blue);
                blue--;
            } else {
                white++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
