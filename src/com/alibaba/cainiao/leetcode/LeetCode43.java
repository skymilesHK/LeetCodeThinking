package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 43. Multiply Strings
 * Medium
 *
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class LeetCode43 {
    int n1 = 0;
    int n2 = 0;

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        n1 = num1.length();
        n2 = num2.length();
        List<Integer> A = new ArrayList<>(n1);
        List<Integer> B = new ArrayList<>(n2);
        for (int i = n1 - 1; i >= 0; i--) {
            A.add(num1.charAt(i) - '0');
        }
        for (int i = n2 - 1; i >= 0; i--) {
            B.add(num2.charAt(i) - '0');
        }

        List<Integer> C = mul(A, B);
        StringBuilder sb = new StringBuilder();
        //若该数的头为0，则去掉（注意：该数的数学顺序是倒序）
        while(C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        for (int i = C.size() - 1; i >= 0; i++) {
            sb.append(C.get(i));
        }
        return sb.toString();
    }

    private List<Integer> mul(List<Integer> A, List<Integer> B) {
        if (n1 < n2) {
            return mul(B, A);
        }

        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i < B.size()) {
                t += A.get(i) * B.get(i);
            } else {
                t += A.get(i);
            }
            A.set(i, t % 10);
            t /= 10;
        }

        while (t > 0) {
            A.add(t % 10);
            t /= 10;
        }
        return A;
    }
}
