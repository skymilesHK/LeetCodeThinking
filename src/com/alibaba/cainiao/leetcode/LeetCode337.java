package com.alibaba.cainiao.leetcode;

import java.util.List;

public class LeetCode337 {
    // https://www.bilibili.com/video/BV16h411X7mY?from=search&seid=5073569606675127668
    int postSum = 0;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.right);
        root.val += postSum;
        postSum += root.val;
        inOrder(root.left);
    }

}
