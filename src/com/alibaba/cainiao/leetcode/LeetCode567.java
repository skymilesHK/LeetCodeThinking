package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        Map<Character, Integer/**个数**/> s1Map = new HashMap<>(s1Len);
        Map<Character, Integer/**个数**/> winMap = new HashMap<>(s2Len);

        for (int i = 0; i < s1Len; i++) {
            char ch = s1.charAt(i);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0, j = i; i < s2Len - s1Len + 1; i++) {
            char ch = s2.charAt(i);
            winMap.put(ch, winMap.getOrDefault(ch, 0) + 1);

            while (j < i && winMap.get(s2.charAt(j)) > s1Map.getOrDefault(s2.charAt(j), 0)) {
                winMap.put(s2.charAt(j), winMap.get(s2.charAt(j)) - 1);
                if (winMap.get(s2.charAt(j)) == 0) {
                    winMap.remove(s2.charAt(j));
                }
                j--;
            }

            if (winMap.equals(s1Map)) {
                return true;
            }
        }

        return false;
    }

}
