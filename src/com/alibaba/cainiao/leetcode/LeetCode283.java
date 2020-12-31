package com.alibaba.cainiao.leetcode;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class LeetCode283 {
    //https://www.acwing.com/video/1657/
    public void moveZeroes(int[] nums) {
        // 将非0数字向前挪 nums = [0, 1, 0, 3, 12]
        // slow之前都是合法数字
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }

        int slow = 0;
        int fast = 0;
        for (; fast < n; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }

    }
}
