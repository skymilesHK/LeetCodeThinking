package com.alibaba.cainiao.leetcode;

/**
 * 654. Maximum Binary Tree
 * Medium
 *
 * 2069
 *
 * 250
 *
 * Add to List
 *
 * Share
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return new TreeNode(nums[0]);
        }

        return dfs(nums, 0, n - 1);
    }

//    算法步骤如下：
//
//    首先调用 dfs(nums, 0, n)，其中 n 是数组 nums 的长度。
//
//    在索引范围 (l:r-1)(l:r−1) 内找到最大值的索引，将 nums[max\_i]nums[max_i] 作为根节点。
//
//    调用 dfs(nums, l, max_i) 创建根节点的左孩子。递归执行此操作，创建根节点的整个左子树。
//
//    类似的，调用 dfs(nums, max_i + 1, r) 创建根节点的右子树。
//
//    方法 dfs(nums, 0, n) 返回最大二叉树的根节点。
    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return new TreeNode(nums[l]);
        } else {
            int idx = findMaxIndex(nums, l, r);
            TreeNode root = new TreeNode(nums[idx]);
            root.left = dfs(nums, l, idx - 1);
            root.right = dfs(nums, idx + 1, r);
            return root;
        }
    }

    private int findMaxIndex(int[] nums, int l, int r) {
        int idx = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

}
