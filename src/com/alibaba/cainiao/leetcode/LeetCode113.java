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

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }

        boolean b = dfs(root, sum, new LinkedList<Integer>());
        return res;
    }

    private boolean dfs(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.val);

        // leaf
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new LinkedList<>(path));
            }
        }

        boolean b = dfs(root.left, sum - root.val, path) || dfs(root.right, sum - root.val, path);

        path.removeLast();

        return b;
    }

}
