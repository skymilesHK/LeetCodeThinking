package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 969. 煎饼排序
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 *
 * 一次煎饼翻转的执行过程如下：
 *
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 arr = [3, 2, 4, 1]
 * 第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
 * 第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
 * 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
 * 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= arr.length
 * arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）
 */
public class LeetCode969 {

    // https://www.youtube.com/watch?v=J3ftj2Hxvv0 (讲解)
    // https://leetcode-cn.com/problems/pancake-sorting/solution/leetcode969jian-bing-pai-xu-by-ma-xiao-yang-2/  (代码)
    public List<Integer> pancakeSort(int[] A) {
        // {3, 2, 4, 1}
        int n = A.length;
        List<Integer> res = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {      //从A.length-1开始，每次循环，都会将前i个数的最大值倒转到第i位。
            int maxIndex = maxIndex(A, i);      //获得前i个数中的最大值的下标
            if (maxIndex != i) {                //如果前i个数的最大值，并不在第i位，说明需要倒转顺序来进行调整
                if (maxIndex == 0) {            //但如果最大值下标已经是第一了，直接倒转
                    res.add(i + 1);
                    reverse(A, i);
                    continue;
                }

                res.add(maxIndex + 1);      //注意i、maxIndex代表一组需要旋转
                res.add(i + 1);

                reverse(A, maxIndex);    //倒转数组(把最大值倒转到第一位)
                reverse(A, i);           //倒转前i个(最终最大值倒转到最后一位)

            }
        }

        return res;
    }

    //寻找到最大值的下标
    private int maxIndex(int[] A, int end) {
        int max = Integer.MIN_VALUE;
        int index = end;
        for (int i = 0; i <= end; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }

    //反转数组
    public void reverse(int[] A, int index) {// n代表下标
        // for (int i = 0; i <= index / 2; i++) {
        //     int tmp = A[i];
        //     A[i] = A[index - i];
        //     A[index - i] = tmp;
        // }

        for (int i = 0, j = index; i < j; i++, j--) {
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }
}
