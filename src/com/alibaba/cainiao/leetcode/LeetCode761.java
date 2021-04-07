package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode761 {
    // https://www.acwing.com/video/2704/
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }

        List<String> levelList = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder(n);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            if (ch == '(') {
                cnt++;
            } else {
                if (--cnt == 0) {
                    levelList.add("1" + makeLargestSpecial(sb.substring(i + 1, n - 1)) + "0");
                    sb = new StringBuilder();
                }
            }
        }

        Collections.sort(levelList, (a, b) -> b.compareTo(a));
        return String.join("", levelList);
    }

}
