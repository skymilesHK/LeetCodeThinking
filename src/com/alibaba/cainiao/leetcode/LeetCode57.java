package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 */
public class LeetCode57 {
    // https://www.youtube.com/watch?v=E9IYRG_WYcM
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int k = 0;
        // 左边没有交集
        while (k < intervals.length && intervals[k][1] < newInterval[0]) {
            res.add(intervals[k]);
            k++;
        }

        if (k < intervals.length) {
            // 更新左端点
            newInterval[0] = Math.min(newInterval[0], intervals[k][0]);
            // 注意这个判断,有交点
            while (k < intervals.length && intervals[k][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[k][1]);
                k++;
            }
        }

        res.add(newInterval);

        //加入右边无交点的区间
        while (k < intervals.length) {
            res.add(intervals[k]);
            k++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
