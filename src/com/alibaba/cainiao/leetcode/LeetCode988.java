package com.alibaba.cainiao.leetcode;

public class LeetCode988 {
    // https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/solution/guan-yu-hui-su-he-dfsde-kun-huo-by-alex-m9/
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }

        s = (char) ('a' + root.val) + s;
        // leaf
        if (root.left == null && root.right == null) {
            if ("".equals(res) || s.compareTo(res) < 0) {
                res = s;
            }
            return;
        }

        dfs(root.left, s);
        dfs(root.right, s);
    }
}
