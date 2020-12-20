package com.alibaba.cainiao.leetcode;

/**
 * 848. 字母移位
 * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
 *
 * 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
 *
 * 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
 *
 * 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
 *
 * 返回将所有这些移位都应用到 S 后最终得到的字符串。
 *
 * 示例：
 *
 * 输入：S = "abc", shifts = [3,5,9]
 * 输出："rpl"
 * 解释：
 * 我们以 "abc" 开始。
 * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
 * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
 * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 * 提示：
 *
 * 1 <= S.length = shifts.length <= 20000
 * 0 <= shifts[i] <= 10 ^ 9
 */
public class LeetCode848 {
    // https://www.youtube.com/watch?v=gOycoA8pOqg
    public String shiftingLetters(String S, int[] shifts) {
        // shifts [3,5,9]
        int[] postSum = new int[shifts.length];
        int m = 0;
        for (int i = shifts.length - 1, j = i; i >= 0 && j >= 0; i--, j--) {
            m = shifts[i] % 26;
            if (j == shifts.length - 1) {
                postSum[j] = m;
            } else {
                postSum[j] = postSum[j + 1] + m;
            }
        }

        // S = "abc", postSum = [17,14,9], S的长度和shifts，postSum长度一样
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < S.length(); i++) {
            sb.setCharAt(i, (char) ((sb.charAt(i) - 'a' + postSum[i]) % 26 + 'a'));
        }

        return sb.toString();
    }
}
