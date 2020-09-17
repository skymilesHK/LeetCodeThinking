package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/brick-wall/solution/zhuan-qiang-by-leetcode/
 */
public class LeetCode554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = wall.size();
        for (int key: map.keySet()) {
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;
    }

}
