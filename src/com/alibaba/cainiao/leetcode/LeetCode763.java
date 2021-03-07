package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class LeetCode763 {

    // https://leetcode-cn.com/problems/partition-labels/solution/java-jian-dan-yi-dong-de-tan-xin-by-leetcoder-youz/
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>(128);
        Map<Character, Integer> map = new HashMap<>(128);
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, map.getOrDefault(S.charAt(i), 0));
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

}
