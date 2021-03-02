package com.alibaba.cainiao.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * Hard
 *
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class LeetCode146 {
    // https://www.acwing.com/video/1520/
    public int maxPoints(int[][] points) {
        // 数目 = max(垂直点个数, 同一个斜率k的个数) + 重叠的点
        int res = 0;
        // 固定一个点，遍历另外一个点
        for (int[] p : points) {
            int sn = 0, vn = 0;
            Map<Double, Integer> map = new HashMap<>(points.length);
            for (int[] q : points) {
                if (p[0] == q[0] && p[1] == q[1]) {
                    sn++;
                } else if (p[0] == q[0]) {
                    vn++;
                } else {
                    double k = div((double) q[1] - p[1], (double) q[0] - p[0]);
                    map.put(k, map.getOrDefault(k, 0) + 1);
                }
            }

            int cnt = sn;
            int max = vn;
            for (Integer v : map.values()) {
                max = Math.max(max, v);
            }
            cnt += max;
            res = Math.max(res, cnt);
        }

        return res;
    }

    //相对精确的除法运算，当发生除不尽的情况时，精确到小数点以后指定精度(scale)，再往后的数字四舍五入
    private double div(double y, double x) {
        BigDecimal by = BigDecimal.valueOf(y);
        BigDecimal bx = BigDecimal.valueOf(x);
        return by.divide(bx, 9, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
