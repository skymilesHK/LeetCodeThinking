package com.alibaba.cainiao.leetcode;

import java.util.List;

public class LeetCode337 {
    public int rob(TreeNode root) {

        int[] dp = dfs(root);
        // root选或者不选的最大值
        return Math.max(dp[0], dp[1]);
    }

    // 返回值int[],表示[root, 0]不选，或者[root, 1]选
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        } else {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            //不选root
            int res1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            //选root
            int res2 = root.val + left[0] + right[0];
            return new int[] {res1, res2};
        }
    }
}
