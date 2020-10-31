package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    // https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        // only left
        if (t2 == null) {
           return t1;
        }

        // only right
        if (t1 == null) {
            return t2;
        }

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t2.right, t2.right);
        return root;
    }

}
