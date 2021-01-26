package com.alibaba.cainiao.leetcode;

/**
 * 713. 乘积小于K的子数组
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 *
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 */
public class LeetCode713 {
    // https://www.acwing.com/solution/content/4081/
    // 输入: nums = [10,5,2,6], k = 100 输出: 8
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0, windowProduct = 0;
        int i = 0, j = 0;

        while (i < n) {
            windowProduct *= nums[i];
            while (j <= i && windowProduct >= k) {
                // 不满足，缩小window
                windowProduct /= nums[j];
                j++;
            }

            // i,j固定了，这个位置贡献的答案就是 i−j+1
            res += i - j + 1;
            i++;
        }

        return res;
    }
}
