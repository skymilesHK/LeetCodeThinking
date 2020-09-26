package com.alibaba.cainiao.leetcode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 632. Smallest Range Covering Elements from K Lists
 * Hard
 *
 *
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
 *
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Example 2:
 *
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 * Example 3:
 *
 * Input: nums = [[10,10],[11,11]]
 * Output: [10,11]
 * Example 4:
 *
 * Input: nums = [[10],[11]]
 * Output: [10,11]
 * Example 5:
 *
 * Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
 * Output: [1,7]
 *
 *
 * Constraints:
 *
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] is sorted in non-decreasing order.
 */
public class LeetCode632 {

    // https://www.youtube.com/watch?v=csJXQZFYklE  思路
    // https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/guan-fang-jie-da-de-zhu-shi-ban-by-ding-k/   代码
    public int[] smallestRange(List<List<Integer>> nums) {

        // 存放k数组中当前判定索引
        int[] currentK = new int[nums.size()];
        // 用队列存储k索引，并且可以根据k数组的值升序排列，栈顶最小为数组当前索引值最小的数组索引
        // int[]第一个值是数组具体值，第二个是组号
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 第一列数，入队列
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).size() == 0) {
                return res;
            }

            pq.offer(new int[] {nums.get(i).get(0), i});
            max = Math.max(max, nums.get(i).get(0));
            min = Math.min(min, nums.get(i).get(0));
        }
        res[0] = min;
        res[1] = max;

        // 到这里pq预先装了k个组的第一个pair元素
        while (!pq.isEmpty()) {
            int group = pq.poll()[1];
            currentK[group]++;
            if (currentK[group] == nums.get(group).size()) {
                break;
            }

            // 增大一个的Pair int[]组
            pq.offer(new int[] {nums.get(group).get(currentK[group]), group});

            // 重算min，max
            max = Math.max(max, nums.get(group).get(currentK[group]));
            min = pq.peek()[0];
            if (max - min < res[1] - res[0]) {
                res[0] = min;
                res[1] = max;
            }
        }

        return res;
    }

}
