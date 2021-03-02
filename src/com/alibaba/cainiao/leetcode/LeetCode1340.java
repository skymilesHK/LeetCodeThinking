package com.alibaba.cainiao.leetcode;

/**
 * https://leetcode-cn.com/problems/jump-game-v/
 *
 * Jump Game V
 */
public class LeetCode1340 {
    // https://www.youtube.com/watch?v=Q2flmQeMxpk

    int[] memo = null;
    public int maxJumps(int[] arr, int d) {
        memo = new int[arr.length + 1];
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(i, arr, d));
        }

        return res;
    }

    private int dfs(int index, int[] arr, int d) {
        if (memo[index] != 0) {
            return memo[index];
        }

        int levelRes = 1;
        for (int len = 1; len <= d; len++) {
            // 注意是break
            if (index + len >= arr.length || arr[index + len] >= arr[index]) {
                break;
            }
            levelRes = Math.max(len, dfs(index + len, arr, d) + 1);
        }

        for (int len = 1; len <= d; len++) {
            // 注意是break
            if (index - len < 0 || arr[index - len] >= arr[index]) {
                break;
            }
            levelRes = Math.max(len, dfs(index - len, arr, d) + 1);
        }

        memo[index] = levelRes;
        return levelRes;
    }
}
