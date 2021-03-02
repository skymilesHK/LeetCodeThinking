package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class LeetCode135 {
    int[] memo = null;
    public int candy(int[] ratings) {
        int n = ratings.length;
        memo = new int[n];
        Arrays.fill(memo, 0x3f3f3f3f);

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dfs(i, ratings);
        }

        return res;
    }

    // 从u点开始左/右最多能拓展几步
    private int dfs(int u, int[] ratings) {
        if (memo[u] != 0x3f3f3f3f) {
            return memo[u];
        }

        int ret = 1;
        if (u > 0 && ratings[u] > ratings[u - 1]) {
            ret = Math.max(ret, dfs(u - 1, ratings) + 1);
        }
        if (u < ratings.length - 1 && ratings[u] > ratings[u + 1]) {
            ret = Math.max(ret, dfs(u + 1, ratings) + 1);
        }
        memo[u] = ret;
        return ret;
    }

}
