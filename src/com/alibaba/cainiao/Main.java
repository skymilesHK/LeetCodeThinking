package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] q = {10,20,5};
        int[] w = {70,50,30};

        LeetCode7 leetCode = new LeetCode7();
        int sqrt = mySqrt(8);
        System.out.println(sqrt);
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 0, end = x, mid = x;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                return mid;
            }
        }

        // t^2 <= x
        if (end <= x / end) {
            return end;
        } else {
            return start;
        }
    }
}