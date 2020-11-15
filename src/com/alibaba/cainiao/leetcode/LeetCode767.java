package com.alibaba.cainiao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class LeetCode767 {

    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = S.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // Impossible to form a solution
            if (map.get(ch) > (chars.length + 1) / 2) {
                return "";
            }
        }

        // push all map entry into priority element, by sorting from high frequency to low frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());

        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            // store character with highest frequency in map
            Map.Entry<Character, Integer> first = pq.poll();

            // if character in map is different with tail character in current string
            if (sb.length() == 0 || !first.getKey().equals(sb.charAt(sb.length() - 1))) {
                if (first.getValue() - 1 > 0) {
                    first.setValue(first.getValue() - 1);
                    pq.offer(first);
                }
                sb.append(first.getKey());
            }
            // if character in cache is same as tail character in current string
            // we need to try the character with second highest frequency
            else {
                Map.Entry<Character, Integer> second = pq.poll();
                if (second.getValue() - 1 > 0) {
                    second.setValue(second.getValue() - 1);
                    pq.offer(second);
                }
                sb.append(second.getKey());
                pq.offer(first);
            }
        }

        return sb.toString();
    }

}
