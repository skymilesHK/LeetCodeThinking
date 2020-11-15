package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 *
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class LeetCode373 {
    // https://www.youtube.com/watch?v=APZbA_q1zAc&t=1103s
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0 || n2 == 0 || k == 0) {
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        // pq第一次放所有nums1和nums2的第一个element
        int idx2 = 0;
        for (int i = 0; i < n1 && i < k; i++) {
            pq.offer(new int[] {nums1[i], nums2[0]});
        }

        // 不断offer新的最小pair
        while (!pq.isEmpty() && k-- > 0) {
            // 最小pair
            int[] pair = pq.poll();
            // 加入res
            res.add(Arrays.asList(pair[0], pair[1]));
            // offer新的pair，拿出nums2下一个index的element
            if (idx2 == n2 - 1) {
                continue;
            }
            pq.offer(new int[] {pair[0], nums2[idx2 + 1]});
        }

        return res;
    }

}
