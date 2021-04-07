package com.alibaba.cainiao.leetcode;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 */
public class LeetCode917 {

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = n - 1;
        while (i < j) {
            char iCh = s.charAt(i);
            char jCh = s.charAt(j);
            if (!Character.isAlphabetic(iCh)) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(jCh)) {
                j--;
                continue;
            }
            sb.setCharAt(i, jCh);
            sb.setCharAt(j, iCh);
            i++;
            j--;
        }
        return sb.toString();
    }

}
