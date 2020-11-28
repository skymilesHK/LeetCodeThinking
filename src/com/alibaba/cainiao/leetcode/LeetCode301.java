package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 */
public class LeetCode301 {

    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        // 统计待删除左右括号数目
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                rmL++;
            } else if (ch == ')') {
                if (rmL == 0) {
                    rmR++;
                } else {
                    rmL--;
                }
            }
        }

        dfs(new StringBuilder(s), 0, rmL, rmR);
        return res;
    }

    // l/r: number of left/right parentheses to remove.
    // "(()))"
    private void dfs(StringBuilder sb, int u, int rmL, int rmR) {
        if (rmL < 0 || rmR < 0) {
            return;
        }
        if (rmL == 0 && rmR == 0) {
            if (isValid(sb)) {
                res.add(new String(sb));
            }
            return;
        }

        int n = sb.length();
        for (int i = u; i < n; i++) {
            if (sb.charAt(i) != '(' && sb.charAt(i) != ')') {
                continue;
            }

            // We only remove the first parentheses if there are consecutive ones to avoid duplications.
            if (i != u && sb.charAt(i) == sb.charAt(i - 1)) {
                continue;
            }
            // copy一份sb,删除i为半括号,i表示当前删除半括号的位置
            StringBuilder cur = new StringBuilder(sb);
            cur.deleteCharAt(i);
            // 还有')'，递归删除')'
            if (sb.charAt(i) == ')' && rmR > 0) {
                dfs(cur, i, rmL, rmR - 1);
            }
            // 还有'('，递归删除'('
            if (sb.charAt(i) == '(' && rmL > 0) {
                dfs(cur, i, rmL - 1, rmR);
            }
        }
    }

    private boolean isValid(StringBuilder sb) {
        int cnt = 0;
        int n = sb.length();
        for (int i = 0; i < n; i++) {
            char ch = sb.charAt(i);
            if (ch == '(') {
                cnt++;
            }
            if (ch == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
