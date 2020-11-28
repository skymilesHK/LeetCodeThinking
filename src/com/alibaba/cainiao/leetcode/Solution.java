package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

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

        path += root.val;

        // leaf
        if (root.left == null && root.right == null) {
            res.add(path);
        }

        if (root.left != null) {
            dfs(root.left, path + "->");
        }

        if (root.right != null) {
            dfs(root.right, path + "->");
        }
    }
}
