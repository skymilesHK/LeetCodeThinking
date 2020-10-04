package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 96. Unique Binary Search Trees
 * Medium
 *
 * 3811
 *
 * 137
 *
 * Add to List
 *
 * Share
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 19
 */
public class LeetCode96 {

    public int numTrees(int n) {
        return generateTrees(n).size();
    }

    private List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        // 以r为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。
        for (int r = left; r <= right; r++) {
            List<TreeNode> leftList = dfs(left, r - 1);
            List<TreeNode> rightList = dfs(r + 1, right);
            for (int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    TreeNode root = new TreeNode(r);
                    root.left = leftList.get(i);
                    root.right = rightList.get(j);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
