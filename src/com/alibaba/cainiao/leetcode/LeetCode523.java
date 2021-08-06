package com.alibaba.cainiao.leetcode;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode523 {
    // https://www.youtube.com/watch?v=0qenZd4G4iI
    //        2
    //        3 4
    //        6 5 7
    //        4 1 8 3
    public int minimumTotal(List<List<Integer>> ll) {
        int n = ll.size();
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> list = ll.get(i);
            for (int j = 0; j <= i; j++) {
                int nextRowV1 = ll.get(i + 1).get(j);
                int nextRowV2 = ll.get(i + 1).get(j + 1);

                list.set(j, Math.min(nextRowV1, nextRowV2) + list.get(j));
            }
        }

        return ll.get(0).get(0);
    }
}
