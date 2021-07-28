package com.alibaba.cainiao.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 862. 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class LeetCode862 {
    // 类似单调栈/单调队列思想, 先靠背
    // https://www.cnblogs.com/grandyang/p/11300071.html   思想
    // https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/solution/javaqian-zhui-he-treemapji-jian-dai-ma-by-he-yun-f/    代码
    public int shortestSubarray(int[] A, int K) {
        TreeMap<Integer/**前缀和**/, Integer/**下标**/> map = new TreeMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0x3f3f3f3f;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            // K <= sum[i] - sum[j]
            // sum[i] - K >= s[j]
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(sum - K);
            if (floorEntry != null && floorEntry.getValue() < res) {
                res = floorEntry.getValue();
            }

            while (!map.isEmpty() && map.lastKey() > sum) { // 因为区间和sumi更小，但是需要的数字反而更多
                map.pollLastEntry();
            }

            map.put(sum, i);
        }

        return res == 0x3f3f3f3f ? -1 : res;
    }
}
