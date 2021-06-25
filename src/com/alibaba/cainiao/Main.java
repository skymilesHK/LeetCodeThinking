package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] a = {9,8,1,0,1,9,4,0,4,1};
        Arrays.stream(a).sum();
        quickSort(a);
        System.out.println(a);
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