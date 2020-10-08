package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Easy
 *
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class LeetCode257 {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return res;
        }

        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += root.val + "->";
        // leaf
        if (root.left == null && root.right == null) {
            res.add(path.substring(0, path.length() - 1));
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }

}
