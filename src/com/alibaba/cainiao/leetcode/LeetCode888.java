package com.alibaba.cainiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */
public class LeetCode888 {
    // https://leetcode-cn.com/problems/fair-candy-swap/solution/guo-ran-zhe-ge-ti-mu-shi-jian-dan-ti-by-8af58/

    // 暴力法
//    public int[] fairCandySwap(int[] A, int[] B) {
//        int aLen = A.length;
//        int bLen = B.length;
//
//        int aSum = 0, bSum = 0;
//        for (int i = 0; i < aLen; i++) {
//            aSum += A[i];
//        }
//
//        for (int i = 0; i < bLen; i++) {
//            bSum += B[i];
//        }
//
//        for (int i = 0; i < aLen; i++) {
//            for (int j = 0; j < bLen; j++) {
//                if (aSum - A[i] + B[j] == bSum - B[j] + A[i]) {
//                    return new int[] {A[i], B[j]};
//                }
//            }
//        }
//
//        return new int[] {};
//    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;

        int aSum = 0, bSum = 0;
        Set<Integer> set = new HashSet<>(aLen);
        for (int i = 0; i < aLen; i++) {
            aSum += A[i];
            set.add(A[i]);
        }

        for (int i = 0; i < bLen; i++) {
            bSum += B[i];
        }

        for (int j = 0; j < bLen; ++j) {
            int should = (aSum - bSum + B[j] * 2) / 2;
            //发现
            if (set.contains(should)) {
                return new int[] {should, B[j]};
            }
        }

        return new int[] {};
    }
}
