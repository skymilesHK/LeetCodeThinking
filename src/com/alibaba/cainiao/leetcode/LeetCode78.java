package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 78. Subsets
 * Medium
 *
 * Given an integer array nums, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class LeetCode78 {

    // 第一种解法
    List<List<Integer>> res = new ArrayList<>();
//    int n = 0;
//
//    // https://www.youtube.com/watch?v=Ld3XkiXys5c&t=211s
//    // https://zxi.mytechroad.com/blog/searching/leetcode-78-subsets/
//    public List<List<Integer>> subsets(int[] nums) {
//        n = nums.length;
//        // 枚举每个位置放什么元素
//        dfs(nums, 0, new ArrayList<Integer>());
//        return res;
//    }
//
//    private void dfs(int[] nums, int start, List<Integer> path) {
//        // 和permutation，combination不一样, 每个中间节点都是答案，都需要存储，所以不能dfs到最下面一层才计算答案
//        res.add(new ArrayList<>(path));
//
//        // 尝试每个数字加入当前位子, 有点像combination，取数不能从i=0开始，应该从i=start(上个数字位置的下一个位置)开始选取,才不会重复，比如，选取了1，2，那么之后不能选取2，1
//        for (int i = start; i < nums.length; i++) {
//            path.add(nums[i]);
//            dfs(nums, i + 1, path);
//            path.remove(path.size() - 1);
//        }
//    }

    // 第二种解法
    // https://www.acwing.com/solution/content/32154/
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int d, List<Integer> path) {
        if (d == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 不选
        dfs(nums, d + 1, path);

        //选
        path.add(nums[d]);
        dfs(nums, d + 1, path);
        path.remove(path.size() - 1);
    }
}
