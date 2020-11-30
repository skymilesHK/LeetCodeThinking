package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Increasing Subsequences
 * Medium
 *
 * 846
 *
 * 128
 *
 * Add to List
 *
 * Share
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
 *
 *
 *
 * Example:
 *
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 *
 * Constraints:
 *
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class LeetCode491 {

    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(nums, 0, 0, new ArrayList<>());
        res.addAll(set);
        return res;
    }

    private void dfs(int[] nums, int u, int start, List<Integer> path) {
        // 类似subset，每个中间节点都是答案，都需要存储，所以不能dfs到最下面一层才计算答案
        if (path.size() >= 2) {
            set.add(new ArrayList<>(path));
        }

        if (u == nums.length) {
            return;
        }

        // 尝试每个数字加入当前位子
        for (int i = start; i < nums.length; i++) {

            int size = path.size();
            if (size == 0 || path.get(size - 1) <= nums[i]) {
                path.add(nums[i]);
                dfs(nums, u + 1, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
