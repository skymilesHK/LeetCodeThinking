package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                res.addFirst(p.val);
                stack.push(p);
                // 注意是right
                p = p.right;
            } else {
                TreeNode t = stack.pop();
                // 注意是left
                p = t.left;
            }
        }

        return res;
    }

}
