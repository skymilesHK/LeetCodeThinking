package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * Easy
 *
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class LeetCode599 {

    public String[] findRestaurant(String[] a, String[] b) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }

        int idx = a.length + b.length - 1;
        List<String> res = new ArrayList<>(idx);
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
                if (map.get(b[i]) + i < idx) {
                    idx = map.get(b[i]) + i;
                    if (!res.isEmpty()) {
                        res.remove(res.size() - 1);
                    }
                    res.add(b[i]);
                } else if (map.get(b[i]) + i == idx) {
                    res.add(b[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

}
