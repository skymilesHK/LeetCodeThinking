package com.alibaba.cainiao.leetcode;

/**
 * 76. Minimum Window Substring
 * Hard
 *
 * 4857
 *
 * 333
 *
 * Add to List
 *
 * Share
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class LeetCode76 {

    // https://www.acwing.com/video/1419/
    public String minWindow(String s, String t) {
        int[] hs = new int[128];
        int[] ht = new int[128];
        String res = "";
        int matchCnt = 0;

        for (int i = 0; i < t.length(); i++) {
            ht[t.charAt(i)]++;
        }

        for ( int l = 0, r = 0; r < s.length(); r++) {
            hs[s.charAt(r)]++;
            // matchCnt 表示t串有多少个字符被s串match，新来的s.charAt(r)，只要个数没有超过t串出现的次数，那么匹配个数就要+1
            if (ht[s.charAt(r)] >= hs[s.charAt(r)]) {
                matchCnt++;
            }

            // 尝试缩小窗口,ht[s.charAt(l)]表示第一个需要匹配的那个字符的个数
            while (l < s.length() && ht[s.charAt(l)] < hs[s.charAt(l)]) {
                hs[s.charAt(l++)]--;
            }

            // 匹配数字==t串长度，说明找到一个解
            if (matchCnt == t.length()) {
                if (res.length() == 0 || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
            }
        }

        return res;
    }

}
