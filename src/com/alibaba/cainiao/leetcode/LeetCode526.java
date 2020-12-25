package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * 526. 优美的排列
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 *
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 *
 * 示例1:
 *
 * 输入: 2
 * 输出: 2
 * 解释:
 *
 * 第 1 个优美的排列是 [1, 2]:
 *   第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
 *   第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
 *
 * 第 2 个优美的排列是 [2, 1]:
 *   第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
 *   第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
 * 说明:
 *
 * N 是一个正整数，并且不会超过15。
 */
public class LeetCode526 {

    boolean[] visited = null;
    int cnt = 0;

    public int countArrangement(int N) {
        int[] nums = IntStream.range(0, N + 1).toArray();
        visited = new boolean[N + 1];
        dfs(nums, N, 1, new LinkedList<>());
        return cnt;
    }

    private void dfs(int[] nums, int N, int u, LinkedList<Integer> path) {
        if (u > N) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (u % i == 0 || i % u == 0)) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, N, u + 1, path);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

}
