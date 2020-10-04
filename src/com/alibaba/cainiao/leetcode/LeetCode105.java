package com.alibaba.cainiao.leetcode;

import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 *
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode105 {

    // https://blog.csdn.net/linhuanmars/article/details/24389549
    // http://www.cnblogs.com/springfor/p/3884034.html (参考 int len = rootIndex - inStart;这段代码)
    // https://www.bilibili.com/video/av61190561 (这段讲解)

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int n = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 先序遍历的从左数第一个为整棵树的根节点
        int rootVal = preorder[preStart];
        // 先序的第一个是root, 通过map获取下标
        Integer inRootIndex = map.get(rootVal);
        // 记录左子树的长度, 维护区间
        int leftLen = inRootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = dfs(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inRootIndex - 1);
        root.right = dfs(preorder, preStart + leftLen + 1, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
    }

}
