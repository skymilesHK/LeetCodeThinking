package com.alibaba.cainiao.leetcode;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class LeetCode643 {

    public double findMaxAverage(int[] nums, int k) {
        double res = Double.MIN_VALUE;
        int n = nums.length;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            if (i - j + 1 > k) {
                sum -= nums[j];
            }
            // 开始前k个不进行计算res
            if (i + 1 >= k) {
                res = Math.max(res, (double) sum / k);
            }
        }

        return res;
    }

}
