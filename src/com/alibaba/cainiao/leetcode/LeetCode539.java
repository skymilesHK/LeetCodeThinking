package com.alibaba.cainiao.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // 转换成分钟
    // 用Set剔除duplicate（直接return 0）
    // 排序
    // 比较最小值和最大值的absolute difference(注意跨天), 再把 i 和 i - 1 互相比较， return 最小值
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        Set<Integer> set = new HashSet<>(n);
        for (int i = 0, k = 0; i < n; i++) {
            int minute = getMinutes(timePoints.get(i));
            minutes[k++] = minute;
            if (!set.add(minute)) {
                return 0;
            }
        }

        Arrays.sort(minutes);

        int min = minutes[0], max = minutes[n - 1];
        // 注意跨天
        int minDiff = Math.min(max - min, 60 * 24 + min - max);
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }

        return minDiff;
    }

    private int getMinutes(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }

}
