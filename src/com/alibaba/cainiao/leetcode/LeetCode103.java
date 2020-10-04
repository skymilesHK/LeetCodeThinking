package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Medium
 *
 * 2576
 *
 * 108
 *
 * Add to List
 *
 * Share
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean flag = true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // flag为true表示为偶数层
            flag = !flag;
            LinkedList<Integer> l = new LinkedList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode t = q.poll();
                if (flag) {
                    l.addFirst(t.val);
                } else {
                    l.addLast(t.val);
                }
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            res.add(l);
        }
        return res;
    }

}
