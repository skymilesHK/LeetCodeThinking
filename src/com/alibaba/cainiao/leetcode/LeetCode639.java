package com.alibaba.cainiao.leetcode;

/**
 * 639. Decode Ways II
 * 639. 解码方法 II
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
 *
 * 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
 *
 * 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
 *
 * 示例 1 :
 *
 * 输入: "*"
 * 输出: 9
 * 解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * 示例 2 :
 *
 * 输入: "1*"
 * 输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
 * 说明 :
 *
 * 输入的字符串长度范围是 [1, 105]。
 * 输入的字符串只会包含字符 '*' 和 数字'0' - '9'。
 */
public class LeetCode639 {

    // https://www.acwing.com/solution/content/4290/
    // https://www.acwing.com/solution/content/495/
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length(), mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            char cur = s.charAt(i - 1);
            char bf = s.charAt(i - 2);
            if (cur == '*') { // 当前字符为 *
                // 如果当前字符是'*'，那么可以直接加上dp[i - 1] * 9，接下来考虑两字符组合的情况，分别讨论1, 2, *的情况就可以了。
                dp[i] = (dp[i] + dp[i - 1] * 9) % mod;
                if (bf == '1') {
                    dp[i] = (dp[i] + dp[i - 2] * 9) % mod;
                } else if (bf == '2') {
                    dp[i] = (dp[i] + dp[i - 2] * 6) % mod;
                } else if (bf == '*') {
                    dp[i] = (dp[i] + dp[i - 2] * 15) % mod;
                }
            } else { // 如果当前字符不是'*'
                // 如果它不是'0'
                if (cur != '0') {
                    dp[i] = (dp[i] + dp[i - 1]) % mod;
                }
                // 接下来考虑两字符组合的情况，如果前一个字符是'1'或者'2'，那么和Decode Ways是一样的，如果是'*'的话，再看当前字符是不是小于或等于'6'。
                if (bf == '1') {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                } else if (bf == '2' && cur <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                } else if (bf == '*') {
                    // bf == '*'
                    if (cur <= '6') {
                        dp[i] = (dp[i] + dp[i - 2] * 2) % mod;
                    } else {
                        dp[i] = (dp[i] + dp[i - 2]) % mod;
                    }
                }
            }
        }

        return (int) dp[n];
    }

}