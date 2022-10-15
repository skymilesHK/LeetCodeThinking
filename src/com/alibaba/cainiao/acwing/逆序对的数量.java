package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 逆序对的数量 {

    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] a;
    static long res = 0L;

    public static void main(String[] args) {
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        mergeSort(a, 0, n - 1);
        System.out.printf("%d", res);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int[] nums = new int[r - l + 1];
        int p = l, q = mid + 1, idx = 0;
        // 合并的第一个数组起始位置p
        // 合并的第二个数组起始位置q
        while (p <= mid && q <= r) {
            if (a[p] > a[q]) {
                res += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }

        // 正常的归并
        p = l;
        q = mid + 1;
        while (p <= mid && q <= r) {
            if (a[p] < a[q]) {
                nums[idx++] = a[p++];
            } else {
                nums[idx++] = a[q++];
            }
        }

        while (p <= mid) {
            nums[idx++] = a[p++];
        }
        while (q <= r) {
            nums[idx++] = a[q++];
        }

        System.arraycopy(nums, 0, a, l, r - l + 1);
    }

}
