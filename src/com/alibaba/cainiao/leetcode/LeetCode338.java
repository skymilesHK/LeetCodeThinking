package com.alibaba.cainiao.leetcode;

/**
 * 题目描述 Counting Bits
 * 给定一个非负整数 numnum，对于所有的 ii，0≤i≤num0≤i≤num，计算出 ii 的二进制表示中1的个数。
 *
 * 进一步：
 *
 * 计算量是 O(nlogn)O(nlogn) 的算法很简单，你能否想出计算量是 O(n)O(n) 的算法?
 * 空间复杂度只能是 O(n)O(n)；
 * 不可以使用C++中的__builtin_popcount等内建函数；
 * 样例
 * 输入：5
 * 输出：[0,1,1,2,1,2]。
 * 算法
 * (动态规划) O(n)
 * 令f[i]表示 i 的二进制表示中1的个数。
 * 则f[i]可以由f[i/2]转移过来，i 的二进制表示和 ⌊i/2⌋ 的二进制表示除了最后一位都一样，所以f[i] = f[i/2] + (i&1);
 *
 * 时间复杂度分析：总共有 nn 个状态，每个状态进行转移的计算量是 O(1)O(1)，所以总时间复杂度是 O(n)O(n)。
 *
 * 作者：yxc
 * 链接：https://www.acwing.com/solution/content/365/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode338 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // dp[i]表示遍历完前i栋以及之前的房子获能获得最大的金额
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1]/**不偷i**/, dp[i - 2] + nums[i - 1]/**偷i**/);
        }

        return dp[n];
    }
}
