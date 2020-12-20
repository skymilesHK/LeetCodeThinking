package com.alibaba.cainiao.leetcode;

/**
 * 151. Reverse Words in a String
 * Medium
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class LeetCode151 {

    // https://www.youtube.com/watch?v=54uU5Zhzorw
    public String reverseWords(String s) {
        if (s == null || 0 == s.length()) {
            return s;
        }

        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }

    // 方法2
    public String reverseWords2(String s) {
        // k表示当前结果实际存的下标
        int k = 0;
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length(); i++) {
            // 过滤连续空格
            while (i < str.length() && str.charAt(i) == ' ') {
                i++;
            }

            if (i == str.length()) {
                break;
            }

            int j = i;
            while (j < str.length() && str.charAt(j) != ' ') {
                j++;
            }
            // [i,j-1]是单词,反转
            reverse(i, j - 1, str);
            // 先塞入一个空格
            if (k > 0) {
                str.setCharAt(k, ' ');
                k++;
            }
            // 再填充k位置的结果
            while (i < j) {
                str.setCharAt(k, str.charAt(i));
                k++;
                i++;
            }
        }
        // delete的方法第二个参数是开区间
        str.delete(k, str.length());
        return str.reverse().toString();
    }

    private void reverse(int i, int j, StringBuilder str) {
        while (i < j) {
            char x = str.charAt(i);
            char y = str.charAt(j);
            str.setCharAt(i, y);
            str.setCharAt(j, x);
            i++;
            j--;
        }
    }
}
