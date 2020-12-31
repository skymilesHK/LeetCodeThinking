package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class LeetCode119 {

    public List<Integer> getRow(int n) {
        List<Integer> line = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            line.add(0, 1);
            for (int j = 1; j < line.size() - 1; j++) {
                line.set(j, line.get(j) + line.get(j + 1));
            }
        }

        return line;
    }

}
