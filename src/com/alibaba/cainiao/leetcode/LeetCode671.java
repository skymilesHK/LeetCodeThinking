package com.alibaba.cainiao.leetcode;

/**
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class LeetCode671 {
    // https://www.youtube.com/watch?v=QXvbRrK1zjY
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return dfs(root, root.val);
    }

    /**
     * 寻找以root为根的树第二小的节点
     * @param root
     * @param small 是当前最小的数字
     * @return
     */
    private int dfs(TreeNode root, int small) {
        if (root == null) {
            return -1;
        }

        // 当前root节点大于
        if (root.val > small) {
            return root.val;
        }

        int sl = dfs(root.left, small);
        int sr = dfs(root.right, small);

        if (sl == -1) {
            return sr;
        }
        if (sr == -1) {
            return sl;
        }

        return Math.min(sl, sr);
    }

}
