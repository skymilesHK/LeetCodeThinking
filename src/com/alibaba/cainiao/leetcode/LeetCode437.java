package com.alibaba.cainiao.leetcode;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class LeetCode437 {

    // 使用两个递归
    // 1.其中一个递归，是一个而外定义的函数，用来计算某个一个开始，树中是否存在和等于sum的路径
    // 2.另外一个递归，则是遍历树中每一个点，套用1的递归判断一次
    // https://www.acwing.com/solution/content/14333/
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        if (sum == 0) {
            res++;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
    }

}
