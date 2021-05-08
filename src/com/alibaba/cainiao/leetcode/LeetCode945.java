package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * Minimum Increment to Make Array Unique
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 样例
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 注意
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class LeetCode945 {
    // https://www.youtube.com/watch?v=ED0QQvgsYo8
    public int minIncrementForUnique(int[] A) {
        // [3,2,1,2,1,7]
        // [1,1,2,2,3,7]
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            int pre = A[i - 1];
            int cur = A[i];
            if (pre >= cur) {
                res += pre - cur + 1;
                A[i] = pre + 1;
            }
        }

        return res;
    }
}
