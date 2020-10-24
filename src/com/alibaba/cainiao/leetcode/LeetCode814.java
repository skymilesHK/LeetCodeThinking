package com.alibaba.cainiao.leetcode;

/**
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class LeetCode814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // leaf
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        // 形如此其实就是，在原树上改
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}
