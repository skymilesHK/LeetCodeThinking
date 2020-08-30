package com.alibaba.cainiao.leetcode;

/**
 * 686. Repeated String Match
 * Easy
 *
 *
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class LeetCode686 {

    // https://www.youtube.com/watch?v=tm0p3KE0KE8&pbjreload=101

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int cnt = 1;
        while (sb.length() < B.length()) {
            sb.append(A);
            cnt++;
        }

        if (sb.indexOf(B) >= 0) {
            return cnt;
        }

        sb.append(A);
        cnt++;
        if (sb.indexOf(B) >= 0) {
            return cnt;
        }
        return -1;
    }

}
