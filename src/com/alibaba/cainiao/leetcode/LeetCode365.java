package com.alibaba.cainiao.leetcode;

public class LeetCode365 {

    // https://www.acwing.com/video/1752/
    // 裴蜀定理
    public boolean canMeasureWater(int a, int b, int c) {
        if (c > a + b) {
            return false;
        }

        return c == 0 || c % gcd(a, b) == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
