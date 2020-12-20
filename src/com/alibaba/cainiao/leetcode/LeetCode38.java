package com.alibaba.cainiao.leetcode;

/**
 * 38. Count and Say
 *
 * https://leetcode.com/problems/count-and-say/
 */
public class LeetCode38 {

    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }

        if (n == 1) {
            return "1";
        }

        String s = "1";
        StringBuilder lastS = null;
        for (int i = 0; i < n - 1; i++) {
            lastS = new StringBuilder();
            // 枚举s的连续段,找第一个不是连续字符的位置
            for (int j = 0; j < s.length(); j++) {
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }

                lastS.append(String.valueOf(k - j) + s.charAt(j));
            }

            s = lastS.toString();
        }

        return s;
    }

}
