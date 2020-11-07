package com.alibaba.cainiao.leetcode;

/**
 * 114. Flatten Binary Tree to Linked List
 * Medium
 *
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class LeetCode114 {

//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        // 后序, 为什么递归要加判断，因为不需要遍历root到leaf节点，而是leaf的上一个根节点
//        if (root.left != null) {
//            flatten(root.left);
//        }
//        if (root.right != null) {
//            flatten(root.right);
//        }
//
//        // 将原左子结点连上父节点的原右子节点上
//        TreeNode tmp = root.right;
//        root.right = root.left;
//        root.left = null;
//
//        // 再把原右子节点连到新右子节点的右子节点上
//        while (root.right != null) {
//            root = root.right;
//        }
//        root.right = tmp;
//    }

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 后序, 为什么递归要加判断，因为不需要遍历root到leaf节点，而是leaf的上一个根节点
        if (root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }

        // 将原左子结点连上父节点的原右子节点上
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        // 再把原右子节点连到新右子节点的右子节点上
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }
}
