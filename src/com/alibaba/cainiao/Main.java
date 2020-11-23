package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] A = {5,2,3,4};

        mergeSort(A, 0, A.length - 1);
        System.out.println(A);
    }

    private static void mergeSort(int[] A, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(A, low, mid);
        mergeSort(A, mid + 1, high);
        merge(A, low, mid, high);
    }

    private static void merge(int[] A, int low, int mid, int high) {
        int[] t = new int[high - low + 1];
        int p = low, q = mid + 1, index = 0;
        while (p <= mid && q <= high) {
            // 逆序
            if (A[p] > A[q]) {
                t[index++] = A[q++];
            } else {
                t[index++] = A[p++];
            }
        }

        // 没使用完
        while (p <= mid) {
            t[index++] = A[p++];
        }

        while (q <= high) {
            t[index++] = A[q++];
        }
        // t已经有序，copy到源A数组
        System.arraycopy(t, 0, A, low, high - low + 1);
    }

}