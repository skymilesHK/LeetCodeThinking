package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // leaf
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);

    }
}
