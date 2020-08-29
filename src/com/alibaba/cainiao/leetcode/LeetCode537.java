package com.alibaba.cainiao.leetcode;

/**
 * 537. Complex Number Multiplication
 * Medium
 *
 * Given two strings representing two complex numbers.
 *
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 *
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class LeetCode537 {

    public String complexNumberMultiply(String a, String b) {
        String[] arr = a.split("\\+", -1);
        String[] brr = b.split("\\+", -1);

        int a0 = Integer.parseInt(arr[0]);
        int a1 = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1));

        int b0 = Integer.parseInt(brr[0]);
        int b1 = Integer.parseInt(brr[1].substring(0, brr[1].length() - 1));

        int one = a0 * b0;
        int two = a0 * b1;
        int three = a1 * b0;
        int four = a1 * b1;

        StringBuilder sb = new StringBuilder();
        int real = one + four * -1;
        int imagine = two + three;
        sb.append(real).append("+").append(imagine).append("i");

        return sb.toString();
    }

}
