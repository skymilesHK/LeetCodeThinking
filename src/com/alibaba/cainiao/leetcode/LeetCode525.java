package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * Medium
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class LeetCode525 {

    // 要求子数组的0和1的个数相同，转换一下，把0换成-1，如果子数组的0和1的个数相同，则换成-1后，这个子数组的和为0。至此，变成了求和为0的最长连续子数组。
    // 遍历数组，维护前缀和，并用map记录前缀和的下标。如果前缀和出现过，其下标为i，当前下标为j，则[i+1, j]这段子数组的和为0。因为一个前缀和可能出现多次，
    // 例如分别在下标为a, b, c时出现，说明[a+1, b]，[b+1, c], [a+1, c]这三段的和都是0。
    // 我们想要的是最长的子数组，因此map记录最前面的下标，即同一个前缀和，只保留第一次出现时的下标。
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = 0,sum = 0;
        Map<Integer/**sum**/, Integer/**下标**/> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i] != 0 ? 1 : -1;
            if (sum == 0) {
                res = i + 1;
            } else if (map.containsKey(sum)) {
                // [map.get(sum) + 1, i]这一段sum==0
                int index = map.get(sum);
                // 注意思考为啥len不用-1
                int len = i - index;
                res = Math.max(len, res);
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }
}
