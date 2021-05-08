package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */
public class LeetCode989 {
    // 输入：A = [1,2,0,0], K = 34
    // 输出：[1,2,3,4]
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> A = new ArrayList<>(num.length);
        // 0,0,2,1
        for (int i = num.length - 1; i >= 0; i--) {
            A.add(num[i]);
        }

        List<Integer> B = new ArrayList<>(num.length);
        while (k != 0) {
            B.add(k % 10);
            k /= 10;
        }

        List<Integer> C = add(A, B);
        Collections.reverse(C);
        return C;
    }

    private List<Integer> add(List<Integer> A, List<Integer> B) {
        int aSize = A.size();
        int bSize = B.size();

        // 进位
        int t = 0;
        for (int i = 0; i < aSize || i < bSize; i++) {
            if (i < aSize) {
                t += A.get(i);
            }
            if (i < bSize) {
                t += B.get(i);
            }

            A.set(i, t % 10);
            t /= 10;
        }

        if (t > 0) {
            A.add(t);
        }

        return A;
    }
}
