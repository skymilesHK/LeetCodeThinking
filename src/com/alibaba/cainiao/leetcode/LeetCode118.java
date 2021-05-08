package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class LeetCode118 {
    // https://www.youtube.com/watch?v=QpLdVwe1hvs
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>(n);
        List<Integer> last = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            last.add(0, 1);
            for (int j = 1; j < last.size() - 1; j++) {
                last.set(j, last.get(j) + last.get(j + 1));
            }
            res.add(new ArrayList<>(last));
        }
        return res;
    }

}
