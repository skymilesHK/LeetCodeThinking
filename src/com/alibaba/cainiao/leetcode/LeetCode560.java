package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class LeetCode560 {
    //         i   0 1 2 3       k = 2
    //      nums =  [1,1,1] 人类下标表示
    //prefixSum = [0,1,2,3] 机器下标表示前缀和

    // 模版题
    // 相当于求下标连续的Si - Sj == k，计为1个
    // 相当于求有几个j，满足Sj = Si - k
    // https://www.acwing.com/video/2021/
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer/**和**/, Integer/**和的次数**/> map = new HashMap<>(n);
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += map.getOrDefault(preSum[i] - k, 0);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        return res;
    }
}
