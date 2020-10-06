package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<Integer> res = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    l.addLast(t.val);
                    if (t.left != null) {
                        q.offer(t.left);
                    }
                    if (t.right != null) {
                        q.offer(t.right);
                    }
                }
            }
            res.add(l.getLast());
        }
        return res;
    }

}
