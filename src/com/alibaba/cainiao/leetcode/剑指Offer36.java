package com.alibaba.cainiao.leetcode;


/**
 * 二叉搜索树与双向链表
 * https://www.acwing.com/problem/content/description/87/
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 注意：
 *
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 */
public class 剑指Offer36 {
    // https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/inorder-traversal-by-supermanblues/
    TreeNode dummy = new TreeNode(0);
    TreeNode prev = dummy;
    public TreeNode convert(TreeNode root) {
        // corner case
        if (root == null) {
            return root;
        }

        dfs(root);
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        prev.right = root;
        root.left = prev;
        prev = root;

        dfs(root.right);
    }
}
