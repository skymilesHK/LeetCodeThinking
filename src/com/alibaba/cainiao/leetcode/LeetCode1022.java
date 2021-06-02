package com.alibaba.cainiao.leetcode;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：3
 *
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 */
public class LeetCode1022 {

    // 用来返回的返回值
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int curr) {
        // 遇到空节点，什么都不做，直接返回
        if (root == null) {
            return;
        }
        // 累加当前节点的值到当前路径和中
        curr = (curr << 1) + root.val;
        // 如果遇到叶子节点，就把路径和放到返回值中
        if (root.left == null && root.right == null) {
            sum += curr;
        }
        // 继续深度优先搜索左右子节点
        dfs(root.left, curr);
        dfs(root.right, curr);
    }

}
