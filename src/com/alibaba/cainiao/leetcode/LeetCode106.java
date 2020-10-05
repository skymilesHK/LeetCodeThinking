package com.alibaba.cainiao.leetcode;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Medium
 *
 * 2091
 *
 * 38
 *
 * Add to List
 *
 * Share
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
// http://www.cnblogs.com/springfor/p/3884034.html
// http://blog.csdn.net/linhuanmars/article/details/24389549
class LeetCode106 {
    HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inOrderLength = inorder.length;
        for (int i = 0; i < inOrderLength; ++i) {
            inMap.put(inorder[i], i);
        }

        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        //1. 中序遍历中根节点是左子树右子树的分割点。
        //2. 后续遍历的最后一个节点为根节点。
        TreeNode root = new TreeNode(postorder[postEnd]);
        Integer rootInOrderIndex = inMap.get(root.val);
        int leftLen = rootInOrderIndex - inStart;

        root.left = dfs(inorder, inStart, rootInOrderIndex - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = dfs(inorder, rootInOrderIndex + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }
}
