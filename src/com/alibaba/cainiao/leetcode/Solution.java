package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }

        return dfs(nums, 0, n - 1);
    }

    // nums[l~r]之前取值，建立nums[mid]为根节点的二叉树，返回这个根节点
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(nums[left]);
        } else {
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid - 1);
            root.right = dfs(nums, mid + 1, right);
            return root;
        }
    }
}
