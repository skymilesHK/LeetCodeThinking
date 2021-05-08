package com.alibaba.cainiao.leetcode;

/**
 * 926. 将字符串翻转到单调递增
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 S 单调递增的最小翻转次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入："00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入："010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入："00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 中只包含字符 '0' 和 '1'
 */
public class LeetCode926 {
    // https://www.youtube.com/watch?v=FhnLePtVrY4
    public int minFlipsMonoIncr(String s) {
        // 1的个数
        int ones = 0;
        // 需要反转的最小个数
        int flip = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (ones == 0) {
                    continue;
                } else {
                    flip++;
                }
            } else {
                ones++;
            }

            if (flip > ones) {
                flip = ones;
            }
        }

        return flip;
    }
}
