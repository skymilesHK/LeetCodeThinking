package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;

/**
 * 60. Permutation Sequence
 *
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class LeetCode60 {

    String res = null;
    boolean[] visited = null;
    int cnt = 0;

    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }

        visited = new boolean[n];
        int nums[] = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        dfs(nums, n, k, 0, new LinkedList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int n, int k, int d, LinkedList<Integer> path) {
        if (d == n) {
            if (++cnt == k) {
                StringBuilder sb = new StringBuilder();
                path.forEach(x -> sb.append(x));
            }
            return;
        }

        // 枚举所有nums的可能值
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, n, k, d + 1, path);
            path.removeLast();
            visited[i] = false;
        }
    }

}
