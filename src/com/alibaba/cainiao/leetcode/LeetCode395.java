package com.alibaba.cainiao.leetcode;

public class LeetCode395 {
    // https://www.acwing.com/video/1785/    思路视频
    // https://www.acwing.com/solution/content/8092/    思路文章
    // https://www.acwing.com/activity/content/code/content/497656/    代码
    public int longestSubstring(String s, int k) {
        // 枚举[j,i]区间中不同字符的种类,窗口维护的是一段子串，要求是最多包含d个不同字符
        int res = 0;
        for (int d = 1; d <= 26; d++) {
            int[] counter = new int[26];
            int i = 0, j = 0;
            int diffCnt = 0;    // [j,i]区间不同种类字符累计数目
            int overKCnt = 0;   // [j,i]区间不同种类字符>=k的数量

            while (i < s.length()) {
                char ch = s.charAt(i);
                counter[ch - 'a']++;
                if (counter[ch - 'a'] == 1) {
                    diffCnt++;
                }
                if (counter[ch - 'a'] == k) {
                    overKCnt++;
                }

                // 不同字符大于d,超过允许枚举的数量,缩小窗口
                while (j < i && diffCnt > d) {
                    char chj = s.charAt(j);
                    if (counter[chj - 'a']-- == k) {
                        overKCnt--;
                    }
                    if (counter[chj - 'a'] == 0) {
                        diffCnt--;
                    }
                    j++;
                }

                // 得到一个答案,看视频08:30
                if (overKCnt == diffCnt) {
                    res = Math.max(res, i - j + 1);
                }

                i++;
            }
        }
        return res;
    }
}
