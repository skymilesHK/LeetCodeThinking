package com.alibaba.cainiao.leetcode;

/**
 * 到最近的人的最大距离
 * https://leetcode-cn.com/problems/maximize-distance-to-closest-person/
 */
public class LeetCode849 {
    // https://www.acwing.com/solution/content/862/     贪心
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int lastIdx = -1, res = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                // 特殊处理第一个 1
                if (res == -1) {
                    res = i;
                } else {
                    res = Math.max(res, (i - lastIdx) / 2);
                }

                lastIdx = i;
            }
        }

        // 最后还需要试一下放到最后的位置上和 last 的距离，更新答案。
        res = Math.max(res, n - 1 - lastIdx);
        return res;
    }

}
