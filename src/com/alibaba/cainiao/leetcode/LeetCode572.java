package com.alibaba.cainiao.leetcode;

/**
 * 572. Subtree of Another Tree
 * Easy
 *
 * 2753
 *
 * 129
 *
 * Add to List
 *
 * Share
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class LeetCode572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }

//        一个树是另一个树的子树 则
//
//        1.要么这两个树相等
//        2.要么这个树是左树的子树
//        3.要么这个树hi右树的子树
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }

        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


}
