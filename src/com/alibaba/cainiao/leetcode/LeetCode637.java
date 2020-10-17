package com.alibaba.cainiao.leetcode;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 * Easy
 *
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class LeetCode637 {

    List<Double> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            double levelSum = 0.0;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    levelSum += t.val;
                    if (t.left != null) {
                        q.offer(t.left);
                    }
                    if (t.right != null) {
                        q.offer(t.right);
                    }
                }
            }

            res.add(levelSum / levelSize);
        }
        return res;
    }

}
