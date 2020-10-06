package com.alibaba.cainiao.leetcode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 */
public class LeetCode124 {

//    // https://www.bilibili.com/video/BV19t411w7Ep   必看解析
//
//    int res = Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        dfs(root);
//        return res;
//    }
//
//    // 1.返回必须经过root点的节点和最大值 2.最少使用左右一边的子节点,不然不是path
//    private int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        //左边右边要结果
//        int leftNodeSum = dfs(root.left);
//        int rightNodeSum = dfs(root.right);
//
//        // 最大值是左边的最大值+右边的最大值+root的值
//        res = Math.max(res, leftNodeSum + rightNodeSum + root.val);
//
//        // 1.向左走节点最大值. 2. 向右走节点最大值 3.不走节点最大值
//        // return 单边
//        return Math.max(0, root.val + Math.max(0, Math.max(leftNodeSum, rightNodeSum)));
//    }

    // https://www.bilibili.com/video/BV19t411w7Ep   必看解析
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return res;
    }

    // 1. 经过root节点(root是最高点的path)
    // 2.最多使用左右一边的子节点,不然不是path
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //左边右边要结果
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        // 最大path=最大值是左边的最大值+右边的最大值+root的值
        res = Math.max(res, leftSum + rightSum + root.val);

        // 1.向左走节点最大值. 2. 向右走节点最大值 3.不走节点最大值
        // return 单边
        return Math.max(0, root.val + Math.max(0, Math.max(leftSum, rightSum)));
    }
}
