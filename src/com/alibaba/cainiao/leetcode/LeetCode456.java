package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 *
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 *
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 */
public class LeetCode456 {
    // [2, 4, 2, 3, 5] https://www.cnblogs.com/grandyang/p/6081984.html
    // 利用递减栈,这样可以知道next greater element。栈里面按顺序放所有大于 third 的数字。也是 pattern 132 中的3
    // 此外维护一个变量 third,也是 pattern 132 中的2。
    // 那么在遍历的时候，如果当前数字nums[i]小于 third，即 pattern 132 中的1找到了, 结束。
    // 如果当前数字大于栈顶元素，那么我们将栈顶数字取出，赋值给 third，然后将该数字压入栈，这样保证了栈里的元素仍然都是大于 third 的，我们想要的顺序依旧存在
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int third = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = n - 1; i >= 0; i--) {
            if (third > nums[i]) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {   // 判定个子高矮(注意没有等于)
                third = stack.pop();                                // 矮个起开，反正也被挡着了。。。
            }

            stack.push(nums[i]);                                    // 进队，接受之后的身高判定吧！
        }

        return false;
    }
}
