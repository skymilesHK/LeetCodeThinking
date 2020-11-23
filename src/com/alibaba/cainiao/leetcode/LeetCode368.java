package com.alibaba.cainiao.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * Medium
 *
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class LeetCode368 {
    // https://www.acwing.com/video/1754/ 讲解
    // https://www.youtube.com/watch?v=hrwP6I5v1XY 代码
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }

        if (n == 1) {
            res.add(nums[0]);
            return res;
        }

        Arrays.sort(nums);
        //记录从0~i包括nums[i]的最大subset的size
        int[] dp = new int[n];
        //记录到当前元素最大size的前一位数的下标
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == dp[j] + 1) {
                        pre[i] = j;
                    }
                }
            }
        }

        int maxLen = 1, maxLenIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxLenIndex = i;
            }
        }

        if (maxLenIndex == -1) {      //每个数都是单独成集合，都不能合并
            res.add(nums[0]);    //随便输出一个数，这里选第一个
            return res;
        }
        int iter = maxLenIndex;
        while (iter != -1) {
            res.addFirst(nums[iter]);
            iter = pre[iter];
        }
        return res;
    }

}
