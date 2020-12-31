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
        List<Integer> line = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            line.add(0, 1);
            for (int j = 1; j < line.size() - 1; j++) {
                line.set(j, line.get(j) + line.get(j + 1));
            }
            res.add(new ArrayList<>(line));
        }

        return res;
    }

}
