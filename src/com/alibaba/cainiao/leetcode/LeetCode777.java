package com.alibaba.cainiao.leetcode;

/**
 * LeetCode 777. 在 LR 字符串中交换相邻字符
 * 题目描述
 * 在一个由 'L'，'R' 和 'X' 三个字符组成的字符串（例如 "RXXLRXRXL"）中进行移动操作。一次移动操作指用一个 "LX" 替换一个 "XL"，或者用一个 "XR" 替换一个 "RX"。现给定起始字符串 start 和结束字符串 end，请编写代码，当且仅当存在一系列移动操作使得 start 可以转换成 end 时，返回 True。
 *
 * 样例
 * 输入：start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出：True
 * 解释：
 * 我们可以通过以下几步将 `start` 转换成 `end`:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * 输入：start = "X", end = "L"
 * 输出：false
 * 输入：start = "LLR", end = "RRL"
 * 输出：false
 * 输入：start = "XL", end = "LX"
 * 输出：true
 * 输入：start = "XLLR", end = "LXLX"
 * 输出：false
 * 限制
 * 1 <= len(start) = len(end) <= 10000
 * start 和 end 中的字符串仅限于 'L'，'R' 和 'X'。
 * 算法
 * (双指针) O(n2)
 * 满足要求的一个必要条件就是 L 和 R 的个数相等，且相对位置结束。
 * 由于 L 只可以向左移动，R 只可以向右移动。如果某个 L 在 start 的位置 i 在 end 的位置 j，发生了 i < j，则说明这个 L 向右移动了，需要返回 false；对于 R 同理。
 * 时间复杂度
 * 两个字符串最多分别遍历一次，故总时间复杂为 O(n)。
 * 空间复杂度
 * 仅需要常数的额外空间。
 *
 */
public class LeetCode777 {

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int n = start.length();
        StringBuilder s = new StringBuilder(n);
        StringBuilder e = new StringBuilder(n);
        int i = 0, j = 0;
        for (; i < n; i++) {
            char ch = start.charAt(i);
            if (ch != 'X') {
                s.append(ch);
            }
        }

        for (; j < n; j++) {
            char ch = end.charAt(j);
            if (ch != 'X') {
                e.append(ch);
            }
        }

        if (!s.equals(e)) {
            return false;
        }

        i = 0;
        j = 0;
        for (; i < n; i++, j++) {
            while (i < n && s.charAt(i) != 'L') {
                i++;
            }
            while (j < n && s.charAt(j) != 'L') {
                j++;
            }
            if (i < j) {
                return false;
            }
        }

        i = 0;
        j = 0;
        for (; i < n; i++, j++) {
            while (i < n && s.charAt(i) != 'R') {
                i++;
            }
            while (j < n && s.charAt(j) != 'R') {
                j++;
            }
            if (i > j) {
                return false;
            }
        }

        return true;
    }

}
