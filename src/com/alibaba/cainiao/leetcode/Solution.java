package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited = null;

    List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        // 枚举每个位置填写什么数字
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }

    // 枚举每个位置u写什么数
    private void dfs(int[] nums, int u, List<Integer> path) {
        if (u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // nums.length, 位置个数是固定的
        for (int i = 0; i < nums.length; i++) {
            // 这个数字没有尝试过
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, u + 1, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
