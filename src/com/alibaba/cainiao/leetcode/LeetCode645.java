package com.alibaba.cainiao.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class LeetCode645 {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int x = 1; x <= n; x++) {
            map.put(x, 1);
        }

        int miss = n + 1, dup = n + 1;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 0) {
                dup = entry.getKey();
            } else if (entry.getValue() > 0) {
                miss = entry.getKey();
            }
        }

        return new int[] {dup, miss};
    }

}
