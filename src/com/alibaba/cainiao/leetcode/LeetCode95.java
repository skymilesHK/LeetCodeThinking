package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * Medium
 *
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
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
 * 0 <= n <= 8
 */
public class LeetCode95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        //从1作为root开始，到n作为root结束
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
            return list;
        }

        // 以r为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。
        for (int r = left; r <= right; r++) {
            List<TreeNode> leftList = dfs(left, r - 1);
            List<TreeNode> rightList = dfs(r + 1, right);

            // 乘法原理
            for (int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(i);
                    root.right = rightList.get(j);
                    list.add(root);
                }
            }
        }

        return list;
    }

}
