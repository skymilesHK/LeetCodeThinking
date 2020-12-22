package com.alibaba.cainiao.leetcode;

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class LeetCode938 {
    // https://www.acwing.com/solution/content/690/
    int res = 0;
    public int rangeSumBST(TreeNode root, int leftVal, int rightVal) {
        dfs(root, leftVal, rightVal);
        return res;
    }

    private void dfs(TreeNode root, int leftVal, int rightVal) {
        if (root == null) {
            return;
        }

        if (leftVal <= root.val && root.val <= rightVal) {
            res += root.val;
        }

        if (leftVal < root.val) {
            dfs(root.left, leftVal, rightVal);
        }

        if (rightVal > root.val) {
            dfs(root.right, leftVal, rightVal);
        }
    }

}
