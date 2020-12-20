package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class LeetCode22 {
    // 规则: leftNum表示左括号剩余数目。rightNum表示右括号剩余数目。
    // 1. 左括号的个数大于等于右括号的个数。我们就可以按照这个规则去打印括号。
    // 2. 如果leftNum>0，则我们可以直接打印左括号，而不违背规则。
    // 3. 能否打印右括号，我们还必须验证leftNum和rightNum的值是否满足规则，如果leftNum>=rightNum，则我们不能打印右括号,否则可以打印右括号。
    // 4. 如果left和right均为零，则说明我们已经完成一个合法排列，可以将其打印出来。

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return res;
    }

    /**
     *
     * @param s
     * @param leftNum  左括号还剩下quota
     * @param rightNum 右括号还剩下quota
     */
    private void dfs(String s, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(s);
            return;
        }

        // 有左括号的quota就打印左括号
        if (leftNum > 0) {
            dfs(s + "(", leftNum - 1, rightNum);
        }
        if (rightNum > 0 && rightNum > leftNum) {
            dfs(s + ")", leftNum, rightNum - 1);
        }
    }

}
