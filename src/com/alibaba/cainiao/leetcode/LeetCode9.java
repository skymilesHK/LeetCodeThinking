package com.alibaba.cainiao.leetcode;

/**
 * 9. Palindrome Number
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder();
            while (x != 0) {
                sb.append(x % 10);
                x /= 10;
            }
            int i = 0, j = sb.length() - 1;
            while (i < j) {
                char a = sb.charAt(i++);
                char b = sb.charAt(j--);
                if (a != b) {
                    return false;
                }
            }
            return true;
        }
    }

}
