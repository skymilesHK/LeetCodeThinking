package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode343 {

    Map<Integer, Integer> memo = new HashMap<>();

    public int integerBreak(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        if (memo.get(n) != null && memo.get(n) > 0) {
            return memo.get(n);
        }

        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            int levelRes = i * (n - i);
            res = Math.max(res, Math.max(levelRes, i * dfs(n - i)));

        }
        memo.put(n, res);
        return res;
    }
}
