package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 *
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 */
public class LeetCode1345 {
    // https://www.acwing.com/solution/content/8350/
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        Map<Integer, Boolean> visited = new HashMap<>(n);
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
            visited.put(arr[i], true);
        }

        Queue<Integer> q = new ArrayDeque<>(n);
        q.offer(0);
        int[] dis = new int[n];
        Arrays.fill(dis, n + 1);

        while (!q.isEmpty()) {
            Integer t = q.poll();
            if (t < n - 1 && dis[t + 1] > dis[t] + 1) {
                dis[t + 1] = dis[t] + 1;
                q.offer(t + 1);
            }

            if (t > 0 && dis[t - 1] > dis[t] + 1) {
                dis[t - 1] = dis[t] + 1;
                q.offer(t - 1);
            }

            if (visited.containsKey(arr[t]) && !visited.get(arr[t])) {
                for (int v : map.get(arr[t])) {
                    if (dis[v] > dis[t] + 1) {
                        dis[v] = dis[t] + 1;
                        q.offer(v);
                    }
                }
            }

            visited.put(arr[t], true);
        }

        return dis[n - 1];
    }
}
