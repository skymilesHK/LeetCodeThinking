package com.alibaba.cainiao.leetcode;

/**
 * 522. 最长特殊序列 II
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 *
 *
 *
 * 示例：
 *
 * 输入: "aba", "cdc", "eae"
 * 输出: 3
 *
 *
 * 提示：
 *
 * 所有给定的字符串长度不会超过 10 。
 * 给定字符串列表的长度将在 [2, 50 ] 之间。
 */
public class LeetCode522 {
    // https://www.acwing.com/solution/content/4849/
    public int nextGreaterElement(int n) {
        if (n <= 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 10);
            n /= 10;
        }

        int[] nums = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            nums[i] = sb.charAt(i) - '0';
        }

        int len = nums.length;
        int replaceIdx = len - 2;
        while (replaceIdx >= 0) {
            if (nums[replaceIdx] < nums[replaceIdx + 1]) {
                break;
            }

            replaceIdx--;
        }

        if (replaceIdx < 0) {
            return -1;
        }

        // replace curr number with the next lowest greater number
        int lgIdx = replaceIdx + 1;
        while (lgIdx < len && nums[lgIdx] > nums[replaceIdx]) {
            lgIdx++;
        }

        swap(nums, replaceIdx, lgIdx - 1);
        reverse(nums, replaceIdx + 1, len - 1);

        long t = 0;
        for (int x : nums) {
            t = t * 10 + x;
        }

        if (t > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
