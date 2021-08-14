package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class LeetCode216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] nums = IntStream.range(1, 10).toArray();
        dfs(nums, 0, 0, k, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, int u, int k, int target, List<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            if (u == k) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, u + 1, k, target - nums[i], path);
            path.remove(path.size() - 1);
        }
    }
}
