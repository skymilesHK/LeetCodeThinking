package com.alibaba.cainiao.leetcode;

/**
 * 678. Valid Parenthesis String
 * Medium
 *
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class LeetCode678 {

    // https://www.cnblogs.com/grandyang/p/7617017.html
    // 第二个解法
    public boolean checkValidString(String s) {
        int lcnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '*') {
                lcnt++;
            } else {
                lcnt--;
            }

            if (lcnt < 0) {
                return false;
            }
        }

        if (lcnt == 0) {
            return true;
        }

        int rcnt= 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '*') {
                rcnt++;
            } else {
                rcnt--;
            }

            if (rcnt < 0) {
                return false;
            }
        }

        return true;
    }

}
