package com.alibaba.cainiao.leetcode;

/**
 * 98. Validate Binary Search Tree
 * Medium
 *
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class LeetCode98 {

//    1. 判断当前节点是否合法并且递归判断左右子树是否合法
//    2. 如果root合法，左子树值的合法范围是开区间（-INF，root.val），右子树为（root.val, INF）
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}
