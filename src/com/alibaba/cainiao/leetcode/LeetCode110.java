package com.alibaba.cainiao.leetcode;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */

public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //拆分成求解左子树和右子树的最大深度
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        //合并，根节点的最大深度=max(左子树最大深度，右子树最大深度)+1
        return Math.max(left, right) + 1;
    }
}
