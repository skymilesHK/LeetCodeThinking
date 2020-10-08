package com.alibaba.cainiao.leetcode;

/**
 * 404. Sum of Left Leaves
 * Easy
 *
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class LeetCode404 {

    TreeNode preRoot = null;

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // leaf
        if (root.left == null && root.right == null) {
            if (preRoot != null && preRoot.left == root) {
                res += root.val;
            }
        }

        dfs(root.left);
        dfs(root.right);
    }

}
