package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    // https://www.acwing.com/video/2519/
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int res = 0, lastLen = 0;
        for (int i = 0, j = i; i < n; i++) {
            j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int curLen = j - i;
            res += Math.min(curLen, lastLen);
            lastLen = curLen;
            i = j - 1;
        }

        return res;
    }
}