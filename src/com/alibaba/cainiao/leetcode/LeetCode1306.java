package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1306. 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class LeetCode1306 {
    // https://leetcode-cn.com/problems/jump-game-iii/solution/javachao-yue-80shen-du-you-xian-sou-suo-hw4ix/
    // bfs版本
    public boolean canReach(int[] A, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        int n = A.length;
        boolean[] visited = new boolean[n]; // visited array
        while (!q.isEmpty()) {
            int idx = q.poll();             // current index;
            if (A[idx] == 0) {
                return true;
            }

            int nextIdx = idx + A[idx];
            if (nextIdx < n && !visited[nextIdx]) {
                visited[nextIdx] = true;
                q.offer(nextIdx);
                if (A[nextIdx] == 0) {
                    return true;
                }
            }

            nextIdx = idx - A[idx];
            if (nextIdx >= 0 && !visited[nextIdx]) {
                visited[nextIdx] = true;
                q.offer(nextIdx);
                if (A[nextIdx] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // dfs版本
    boolean[] visited = null;
    int n = 0;

    public boolean canReach2(int[] A, int start) {
        n = A.length;
        visited = new boolean[n];
        return dfs(A, start);
    }

    private boolean dfs(int[] A, int start) {
        if (start < 0 || start >= n) {
            return false;
        }

        if (A[start] == 0) {
            return true;
        }

        int nextIdx = start + A[start];
        if (nextIdx < n && !visited[nextIdx]) {
            visited[nextIdx] = true;
            if (dfs(A, nextIdx)) {
                return true;
            }
        }

        nextIdx = start - A[start];
        if (nextIdx >= 0 && !visited[nextIdx]) {
            visited[nextIdx] = true;
            if (dfs(A, nextIdx)) {
                return true;
            }
        }

        return false;
    }
}
