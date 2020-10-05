package com.alibaba.cainiao.leetcode;


/**
 * 111. Minimum Depth of Binary Tree
 * Easy
 *
 * 1707
 *
 * 752
 *
 * Add to List
 *
 * Share
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class LeetCode111 {

    int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }

        // leaf
        if (root.left == null && root.right == null) {
            res = Math.min(res,d);
        }

        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
}
