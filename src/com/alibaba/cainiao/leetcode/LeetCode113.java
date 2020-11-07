package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 * Medium
 *
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class LeetCode113 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int curSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        // leaf
        if (root.left == null && root.right == null) {
            if (root.val == curSum) {
                res.add(new LinkedList<>(path));
            }
        }

        dfs(root.left, curSum - root.val, path);
        dfs(root.right, curSum - root.val, path);
        path.removeLast();
    }
}
