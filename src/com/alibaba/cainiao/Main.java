package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static final int N = 100001;

    public static void main(String[] args) {
        // 1 2 2 3 5
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = in.nextInt();
        }

        int j = 0;
        for (int i = 0; i < B.length && j < A.length; i++) {
            if (A[j] == B[i]) {
                j++;
            }
        }

        if (j == A.length) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}