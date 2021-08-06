package com.alibaba.cainiao.leetcode;

/**
 * 410. 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 */
public class LeetCode410 {
    // https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-liweiwei1419-4/ 文字部分
    // https://www.acwing.com/video/1806/   视频
    // 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。那么二分每个连续子数组的每个总和小于等于mid
    public int splitArray(int[] nums, int m) {
        // start,end,mid都是连续子数组和的含义
        int start = 0, end = 0x3f3f3f, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (check(nums, m , mid)) {
                // 需要缩小mid，扩大m
                end = mid;
            } else {
                // mid太小了，m太大了
                start = mid;
            }
        }

        if (check(nums, m , start)) {
            return start;
        } else {
            return end;
        }
    }

    // 判断nums能否分成cnt段<=m,每段最大和小于等于mid
    private boolean check(int[] nums, int m, int mid) {
        int sum = 0, cnt = 0;
        for (int x : nums) {
            if (x > mid) {
                // 直接不行
                return false;
            }

            if (sum + x > mid) {
                // 新的一个子数组
                sum = 0;
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        if (sum != 0) {
            cnt++;
        }
        return cnt <= m;
    }
}
