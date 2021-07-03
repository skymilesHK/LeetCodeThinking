package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int solve = solve("abcabcbb");
        System.out.println(solve);
    }

    static public int solve(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        Map<Character/**字符**/, Integer/**个数**/> map = new HashMap<>();
        int res = 0;

        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // 这段弄啥呢
            // 这段是，缩短区间,[j,i]这段区间找,滑动窗口,我拷贝到本地跑下
            while (map.get(ch) >= 2) {
                // 减小j边界
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    private static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = A[l];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (A[i] < pivot);

            do {
                j--;
            } while (A[j] > pivot);

            if (i < j) {
                swap(A, i, j);
            }
        }

        quickSort(A, l, j);
        quickSort(A, j + 1, r);
    }

    private static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}