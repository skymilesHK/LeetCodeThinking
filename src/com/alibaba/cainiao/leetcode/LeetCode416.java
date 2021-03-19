package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class LeetCode416 {

    /**
     * ①状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于j是否成立，成立为true
     * ②状态转移方程(分类讨论)：
     *  a.不选择i位置的值：dp[i][j] = dp [i - 1][j]
     *  b.选择i位置的值:
     *      I.当j > nums[i]时, dp[i][j] = dp [i - 1][j] || dp [i - 1][j - nums[i]]
     *     II.当j = nums[i]时，dp[i][j] = true
     *    III.当j < nums[i]时, dp[i][j] = dp [i - 1][j] （dp [i - 1][j - nums[i]]不存在）
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        // sum为奇数，不符合题意，返回false
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        //dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于背包容量j是否成立，成立为true
        boolean[][] dp = new boolean[n][target + 1];
        //初始化初值:第一行只有第1个数只能让容积为它自己的背包恰好装满
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp [i - 1][j] || dp [i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }

        return dp[n - 1][target];
    }

}
