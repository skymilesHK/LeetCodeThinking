package com.alibaba.cainiao.leetcode;

/**
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *
 *
 * 提示：
 *
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 */
public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        if ("".equals(num) || k == 0) {
            return num;
        }
        if (k > num.length()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            // 递增栈，如果是递减栈，num=4321，那么就无意义了
            // 当还可以删的时候，并且比答案里的最后一位要小，那就把它删除掉
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                sb = sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(num.charAt(i));
        }

        // num="9", k=1
        // 如果还没删完，就从后往前删
        while (k > 0) {
            k--;
            sb = sb.deleteCharAt(sb.length() - 1);
        }

        // leading 0, 去除0
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

}
