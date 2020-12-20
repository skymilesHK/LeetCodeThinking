package com.alibaba.cainiao.leetcode;

/**
 * 6. ZigZag Conversion
 * Medium
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class LeetCode6 {

    // https://www.bilibili.com/video/av67735634?from=search&seid=5567045649365268921
    public String convert(String s, int nRows) {
        if (nRows <= 1) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int idx = 0;
        while (idx < s.length()) {
            // 竖直方向
            for (int i = 0; i < nRows && idx < s.length(); i++) {
                sbs[i].append(s.charAt(idx++));
            }

            // 斜方向
            for (int i = nRows - 1 - 1; i >= 1; i--) {
                sbs[i].append(s.charAt(idx++));
            }
        }

        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i]);
        }

        return sbs[0].toString();
    }

}
