package com.alibaba.cainiao.leetcode;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class LeetCode394 {
    // 为啥需要全局变量位置下标？仅当递归子问题的参数也需要反向影响父递归问题的参数的时候
    private int u = 0;
    private int n = 0;

    public String decodeString(String s) {
        n = s.length();
        if (n == 0) {
            return "";
        }

        StringBuilder path = new StringBuilder();
        dfs(s, path);
        return path.toString();
    }

    private void dfs(String s, StringBuilder path) {
        int num = 0;
        while (u < n) {
            char ch = s.charAt(u);
            u++;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                // "["
                //求解子问题
                StringBuilder sb = new StringBuilder();
                dfs(s, sb);
                String sub = sb.toString();
                do {
                    path.append(sub);
                } while (--num > 0);
            } else if (Character.isAlphabetic(ch)) {
                path.append(ch);
            } else {
                // "]"
                // 跳出循环,返回上一次调用
                break;
            }
        }
    }

}
