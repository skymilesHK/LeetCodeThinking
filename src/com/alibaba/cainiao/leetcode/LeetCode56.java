package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 * Medium
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class LeetCode56 {
    // https://www.acwing.com/video/1393/ 只看中文解释
    // 方法2，模版题
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        if (m == 0 || intervals[0].length == 0) {
            return new int[][] {};
        }
        int n = intervals[0].length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>(m);
        res.add(intervals[0]);

        for (int i = 1; i < m; i++) {
            int[] lastArray = res.get(res.size() - 1);
            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
