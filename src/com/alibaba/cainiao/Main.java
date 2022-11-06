package com.alibaba.cainiao;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static int N = 100001;
    static int[] nums = new int[N];

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        // 进行快速排序
        quickSort(0, n - 1);
    }

    private static void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i < j) {
                swap(nums, i, j);
            }
        }

        quickSort(l, j);
        quickSort(j + 1, r);
    }

    private static void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
}
