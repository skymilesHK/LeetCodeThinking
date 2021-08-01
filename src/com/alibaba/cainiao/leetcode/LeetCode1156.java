package com.alibaba.cainiao.leetcode;

/**
 * 1156. 单字符重复子串的最大长度
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 *
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 *
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 *
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 *
 * 输入：text = "abcdef"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 */

public class LeetCode1156 {
    // https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring/solution/javazhu-zhan-ban-yun-qiu-jie-fu-za-du-by-xdvn/
    // text = "aaabaaa"
    public int maxRepOpt1(String text) {
        int[] hash = new int[26];
        int max = 0;
        //统计数量和最大值
        for(char c : text.toCharArray()) {
            hash[c - 'a']++;
            max = Math.max(max, hash[c - 'a']);
        }
        //最大值不大于1，说明每种字符最多不超过1个，因此最多为最大值
        if(max <= 1) return max;
        max = 1;
        int i = 0, n = text.length();
        while(i < n) {
            int j = i;
            char ch = text.charAt(i);
            // find the left side length;
            // 查找与i相同的子串，最终子串为[i, j)
            while(j < n && text.charAt(j) == ch) j++;
            //此时j为与i不同的字符
            int k = j + 1;
            // find the right side length;
            // 右侧查找与i相同的子串，最终子串为[j+1, k)
            while(k < n && text.charAt(k) == ch) k++;
            // max should be  the longest of (left + right)
            //最大值为j左侧加右侧，即j - i + k - (j + 1) = k-i-1即字符i的数量，如果i的数量等于i的总数，那么不能再替换，否则还可以替换掉j位置的字符
            max = Math.max(max, (k - i - 1 == hash[ch - 'a']) ? k - i - 1 : k - i);
            i = j;
        }
        return max;
    }
}
