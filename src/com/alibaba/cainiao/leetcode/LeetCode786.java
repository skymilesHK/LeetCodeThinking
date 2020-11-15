package com.alibaba.cainiao.leetcode;

import java.util.PriorityQueue;

/**
 * 786. K-th Smallest Prime Fraction
 *
 * A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.
 *
 * What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.
 *
 * Examples:
 * Input: A = [1, 2, 3, 5], K = 3
 * Output: [2, 5]
 * Explanation:
 * The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * The third fraction is 2/5.
 *
 * Input: A = [1, 7], K = 1
 * Output: [1, 7]
 * Note:
 *
 * A will have length between 2 and 2000.
 * Each A[i] will be between 1 and 30000.
 * K will be between 1 and A.length * (A.length - 1) / 2.
 */
public class LeetCode786 {

    //https://www.jiuzhang.com/solution/k-th-smallest-prime-fraction/#tag-lang-java
    // A = [1, 2, 3, 5]
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        // 实际上是Pa/Qa - Pb/Qb 同乘QaQb后的结果
        PriorityQueue<int[]/**放入的是index**/> pq = new PriorityQueue<>((a, b) -> {
            double r1 = (double) (A[a[0]]) / (double) (A[a[1]]);
            double r2 = (double) (A[b[0]]) / (double) (A[b[1]]);
            if (Math.abs(r1 - r2) < 0.0000001) {
                return 0;
            } else {
                return r1 < r2 ? -1 : 1;
            }
        });

        // 此处放入的是第0个索引与第i个索引，类似多路归并
        // (0,3) (0,2) (0,1)
        for (int i = 1; i < n; ++i) {
            pq.add(new int[] {0, i});
        }

        // 扔出K-1个最小值, 因为已经添加过了一个
        while (!pq.isEmpty() && --K > 0) {
            int[] t = pq.poll();
            // 将最小值分子的索引+1放入堆中
            if (t[0] + 1 == n - 1) {
                continue;
            }
            // 将合法最小值分子的索引+1放入堆中
            if (t[0]++ < t[1]) {
                pq.offer(t);
            }
        }

        int[] res = pq.poll();
        return new int[] {A[res[0]], A[res[1]]};
    }


}
