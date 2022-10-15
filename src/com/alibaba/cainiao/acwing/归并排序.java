package com.alibaba.cainiao.acwing;

public class 归并排序 {

//    public static void main(String[] args) {
//        int[] a = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
//        mergeSort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//    }
//
//    private static void mergeSort(int[] a) {
//        mergeSort(a, 0, a.length - 1);
//    }
//
//    private static void mergeSort(int[] a, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//
//        int mid = l + (r - l) / 2;
//        mergeSort(a, l, mid);
//        mergeSort(a, mid + 1, r);
//        merge(a, l, mid, r);
//    }
//
//    private static void merge(int[] a, int l, int mid, int r) {
//        int[] nums = new int[r - l + 1];
//        // 合并的第一个数组p下标
//        // 合并的第二个数组q下标
//        int p = l, q = mid + 1;
//        // 新数组的下标
//        int idx = 0;
//        while (p <= mid && q <= r) {
//            if (a[p] <= a[q]) {
//                nums[idx++] = a[p++];
//            } else {
//                nums[idx++] = a[q++];
//            }
//        }
//
//        while (p <= mid) {
//            nums[idx++] = a[p++];
//        }
//
//        while (q <= r) {
//            nums[idx++] = a[q++];
//        }
//
//        System.arraycopy(nums, 0, a, l, r - l + 1);
//    }


}

