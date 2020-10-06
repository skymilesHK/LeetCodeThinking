package com.alibaba.cainiao.leetcode;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //交换左右子树
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
