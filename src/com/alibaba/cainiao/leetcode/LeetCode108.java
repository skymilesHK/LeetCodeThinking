package com.alibaba.cainiao.leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Easy
 *
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }

        return dfs(nums, 0, n - 1);
    }

    // nums[l~r]之前取值，建立nums[mid]为根节点的二叉树，返回这个根节点
    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return new TreeNode(nums[l]);
        } else {
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, l, mid - 1);
            root.right = dfs(nums, mid + 1, r);
            return root;
        }
    }

}
