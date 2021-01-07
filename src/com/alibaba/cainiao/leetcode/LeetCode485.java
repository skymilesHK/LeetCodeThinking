package com.alibaba.cainiao.leetcode;

public class LeetCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int cnt = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }

        // 因为最后一次连续序列在循环中无法比较，所以在循环外进行比较
        res = Math.max(res, cnt);
        return res;

    }

}
