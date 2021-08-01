package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. 至多包含 K 个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */
public class LeetCode340 {
    // https://www.youtube.com/watch?v=roDQuIVQ3m4
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();

        Map<Character/**字符**/, Integer/**次数**/> map = new HashMap<>(n);
        int res = 0;
        for (int i = 0, j = i; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // 加入以后不符合k个以内,缩小窗口
            while (map.size() > k) {
                char chj = s.charAt(j);
                int cnt = map.get(chj) - 1;
                if (cnt == 0) {
                    map.remove(chj);
                } else {
                    map.put(chj, cnt);
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }

        return res;
    }

}
