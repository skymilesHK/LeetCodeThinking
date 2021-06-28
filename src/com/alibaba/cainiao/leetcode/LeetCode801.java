package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 801. 使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 *
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 *
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 *
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 *
 * 示例:
 * 输入: A = [1,3,5,4], B = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * 注意:
 *
 * A, B 两个数组的长度总是相等的，且长度的范围为 [1, 1000]。
 * A[i], B[i] 均为 [0, 2000]区间内的整数。
 *
 */
public class LeetCode801 {
    // https://www.acwing.com/video/2826/
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //dp(i,0) 表示使 A[0] 到 A[i] 和 B[0] 到 B[i] 严格单调递增，且 A[i] 没有与 B[i] 交换的的最小交换次数。
        //dp(i,1) 表示使 A[0] 到 A[i] 和 B[0] 到 B[i] 严格单调递增，且 A[i] 有与 B[i] 交换的的最小交换次数。
        int[][] dp = new int[n][2];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
