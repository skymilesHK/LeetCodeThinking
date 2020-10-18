package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 662. Maximum Width of Binary Tree
 * Medium
 *
 * 1799
 *
 * 342
 *
 * Add to List
 *
 * Share
 * Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Constraints:
 *
 * The given binary tree will have between 1 and 3000 nodes.
 */
public class LeetCode662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode t = q.poll();
                Integer tIdx = l.removeFirst();
                if (t != null) {
                    if (t.left != null) {
                        q.offer(t.left);
                        l.add(2 * tIdx);
                    }
                    if (t.right != null) {
                        q.offer(t.right);
                        l.add(2 * tIdx + 1);
                    }
                }
            }

            // l 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
            if (l.size() >= 2) {
                res = Math.max(res, l.getLast() - l.getFirst() + 1);
            }
        }

        return res;
    }

}
