package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 67. Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class LeetCode67 {

    // https://www.yuque.com/skymiles/av37cu/fq2emr
    public String addBinary(String a, String b) {
        List<Integer> A = new ArrayList<>(a.length());
        List<Integer> B = new ArrayList<>(b.length());

        for (int i = a.length() - 1; i >= 0; i--) {
            A.add(a.charAt(i) - '0');
        }

        for (int i = b.length() - 1; i >= 0; i--) {
            A.add(b.charAt(i) - '0');
        }

        return add(A, B);
    }

    private String add(List<Integer> A , List<Integer> B) {
        if (A.size() < B.size()) {
            return add(B, A);
        }

        StringBuilder sb = new StringBuilder();
        // 进位
        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            t += A.get(i);
            if (i < B.size()) {
                t += B.get(i);
            }
            A.set(i, t % 2);
            t /= 2;
        }

        if (t > 0) {
            A.add(1);
        }

        A.forEach(x -> sb.append(x));
        return sb.reverse().toString();
    }
}
