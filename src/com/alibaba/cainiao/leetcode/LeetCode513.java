package com.alibaba.cainiao.leetcode;

/**
 * 513. Find Bottom Left Tree Value
 * Medium
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class LeetCode513 {

    int res = 0;
    int maxDepth = 1;

    public int findBottomLeftValue(TreeNode root) {
        res = root.val;
        preOrder(root, 1);
        return res;
    }

    private void preOrder(TreeNode root, int d) {
        if (root == null) {
            return;
        }

        if (d > maxDepth) {
            maxDepth = d;
            res = root.val;
        }

        preOrder(root.left, d + 1);
        preOrder(root.right, d + 1);
    }

}
