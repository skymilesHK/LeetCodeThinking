package com.alibaba.cainiao.leetcode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LeetCode687 {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        int single = dfs(root);
        return res;
    }

    //  返回值是必须经过root节点的单向(左右只取一个)相同值的路径长度, root为最高点
    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPathLen = dfs(node.left);
        int rightPathLen = dfs(node.right);

        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += leftPathLen + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrowRight += rightPathLen + 1;
        }

        res = Math.max(res, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);

    }
}
