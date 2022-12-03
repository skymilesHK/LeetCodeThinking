package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 17. Letter Combinations of a Phone Number
 * Medium
 * <p>
 * 13297
 * <p>
 * 779
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LeetCode17 {

    private List<String> res = new ArrayList<>();
    // 把table上的数字对应的字母列出来，当输入为2是，digits[2]就是2所对应的"abc"
    private String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private int n = 0;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        n = digits.length();
        // 枚举每个数字
        dfs(digits, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int idxOfWord, int idxOfDigit, StringBuilder path) {
        if (idxOfDigit == n) {
            res.add(path.toString());
            return;
        }

        char ch = digits.charAt(idxOfDigit);
        String keys = table[ch - '0'];
        // 每次 从头 枚举每个对应的字母key, 因为每个key只会选一次
        for (int i = 0; i < keys.length(); i++) {
            path.append(keys.charAt(i));
            dfs(digits, i + 1, idxOfDigit + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
