package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 850. 矩形面积 II
 * 我们给出了一个（轴对齐的）矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形 i 左下角的坐标，（x2，y2）是该矩形右上角的坐标。
 *
 * 找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * 输出：6
 * 解释：如图所示。
 * 示例 2：
 *
 * 输入：[[0,0,1000000000,1000000000]]
 * 输出：49
 * 解释：答案是 10^18 对 (10^9 + 7) 取模的结果， 即 (10^9)^2 → (-7)^2 = 49 。
 * 提示：
 *
 * 1 <= rectangles.length <= 200
 * rectanges[i].length = 4
 * 0 <= rectangles[i][j] <= 10^9
 * 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。
 */

class LeetCode850 {
    long mod = (long) (1E9 + 7);
    public int rectangleArea(int[][] rectangles) {
        // 竖线
        List<Integer> vl = new ArrayList<>();
        for (int[] r : rectangles) {
            vl.add(r[0]);
            vl.add(r[2]);
        }

        Collections.sort(vl);
        long res = 0;
        // 枚举竖线
        for (int i = 1; i < vl.size(); i++) {
            res += cal(rectangles, vl.get(i - 1), vl.get(i));
        }

        return (int) (res % mod);
    }

    private long cal(int[][] rectangles, int a, int b) {
        List<int[]> yList = new ArrayList<>();
        for (int[] r : rectangles) {
            // 不在区域内
            if (r[0] <= a && r[2] >= b) {
                int[] pair = {r[1], r[3]};
                yList.add(pair);
            }
        }

        Collections.sort(yList, (x, y) -> x[0] - y[0]);
        long yLen = 0L, start = -1, end = -1;
        for (int[] pair : yList) {
            if (pair[0] > end) {
                yLen += end - start;
                start = pair[0];
                end = pair[1];
            } else if (pair[1] > end) {
                end = pair[1];
            }
        }
        yLen += end - start;
        return yLen * (b - a);
    }

}
