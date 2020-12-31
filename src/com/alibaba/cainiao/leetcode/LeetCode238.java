package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class LeetCode238 {

    //(前缀积)
    //利用 prefix 数组当做临时存储空间，令 prefix[i] 为从 nums[0] * nums[1] * ... * num[i - 1]。
    //然后从数组末尾，用变量 endProduct 记录末尾若干数字的乘积，每次更新 prefix[i] 即可得到答案。
    //Input:  [1,2,3,4]
    //Output: [24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);
        for (int i = 0; i < n; i++) {
            //  不能是prefix[i - 1] * nums[i]，因为是前缀积，不是到当前数的积
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int endProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] *= endProduct;
            endProduct *= nums[i];
        }

        return prefix;
    }

}
