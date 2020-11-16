package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class LeetCode94 {

    List<Integer> res = new ArrayList<>();
//    // 递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return res;
//        }
//
//        inOrder(root);
//        return res;
//    }
//
//    private void inOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        inOrder(root.left);
//        res.add(root.val);
//        inOrder(root.right);
//    }

    // 非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
