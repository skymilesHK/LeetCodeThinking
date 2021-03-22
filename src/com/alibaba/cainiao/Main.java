package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n, m = 0;
    static int[][] g;
    static int[] d;
    static boolean[] st;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {4,6,15,35};
        solution.largestComponentSize(A);
    }
}