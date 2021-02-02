package com.alibaba.cainiao.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class LeetCode128 {

    // https://www.acwing.com/video/1492/
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        Set<Integer> set = new HashSet<>(n);
        Arrays.stream(nums).forEach(u -> set.add(u));

        int res = 0;
        for (int x : nums) {
            if (set.contains(x) && !set.contains(x - 1)) {
                // 一定要删除,防止重复枚举
                set.remove(x);
                // x有了，然后从x+1枚举
                int y = x;
                while (set.contains(y + 1)) {
                    y++;
                    // 一定要删除,防止重复枚举
                    set.remove(y);
                }

                res = Math.max(res, y - x + 1);
            }
        }

        return res;
    }

}
