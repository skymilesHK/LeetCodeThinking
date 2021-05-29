package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 539. Minimum Time Difference
 * Medium
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class LeetCode539 {

    // https://www.acwing.com/video/1997/
    // 转换成分钟
    // 用Set剔除duplicate（直接return 0）
    // 排序
    // 比较最小值和最大值的absolute difference(注意跨天), 再把 i 和 i - 1 互相比较， return 最小值
    public int findMinDifference(List<String> tList) {
        int n = tList.size(), res = 0x3f3f3f3f;
        List<Integer> minList = new ArrayList<>(n);

        for (String x : tList) {
            String[] split = x.split(":");
            minList.add(60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }

        Collections.sort(minList);

        // 注意跨天，注意并不是每个用例不都是zero时间base的
        for (int i = 1; i < n; i++) {
            res = Math.min(res, minList.get(i) - minList.get(i - 1));
        }
        res = Math.min(res, 24 * 60 - minList.get(minList.size() - 1) + minList.get(0));
        return res;
    }
}
