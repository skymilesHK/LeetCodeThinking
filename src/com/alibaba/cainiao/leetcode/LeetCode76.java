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
            // matchCnt 表示t串有多少个字符被match，注意是<=, 因为刚刚hs[s.charAt(r)]++; =也表示之前是少一个的字符匹配的
            if (ht[s.charAt(r)] >= hs[s.charAt(r)]) {
                matchCnt++;
            }

            // 开始缩小窗口
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
