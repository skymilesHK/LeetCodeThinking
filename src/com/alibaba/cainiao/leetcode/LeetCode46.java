package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */

public class LeetCode46 {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited = null;

    public List<List<Integer>> permute(int[] nums) {
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
