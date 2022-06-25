package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 快速排序 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // 将输入数据进行初始化
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        // 进行快速排序
        quickSort(nums, 0, n - 1);

        // 打印输出
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }

    private static void quickSort(int[] nums, int l, int r) {
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

        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
