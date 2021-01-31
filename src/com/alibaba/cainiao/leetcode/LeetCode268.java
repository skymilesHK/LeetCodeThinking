package com.alibaba.cainiao.leetcode;

/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 *
 * 进阶：
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 *
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 *
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 */
public class LeetCode268 {

    //(前缀积)
    //利用 prefix 数组当做临时存储空间，令 prefix[i] 为从 nums[0] * nums[1] * ... * num[i - 1]。
    //然后从数组末尾，用变量 endProduct 记录末尾若干数字的乘积，每次更新 prefix[i] 即可得到答案。
    //Input:  [1,2,3,4]
    //Output: [24,12,8,6]
    //https://www.acwing.com/video/1622/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 前缀积
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = 1;
            //不能是prefix[i - 1] * nums[i]，因为是前缀积，不是到当前数的积
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return prefix;
    }
}
