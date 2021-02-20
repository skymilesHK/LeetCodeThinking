package com.alibaba.cainiao.leetcode;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class LeetCode50 {
    // https://www.acwing.com/video/300/
    public double myPow(double a, int n) {

        if (n == 0) {
            return 1.0;
        }
        if (a == 1.0) {
            return 1.0;
        }

        return n >= 0 ? qmi(a, n) : (1.0 / qmi(a, (long) -n));
    }

    // 快速幂a^k
    private double qmi(double a, long k) {
        double res = 1.0;
        // k的二进制表示
        while (k > 0) {
            // k的二进制表示末位是1的话
            if ((k & 1) == 1) {
                res = res * a;
            }
            // 删除末位
            k >>= 1;
            // a平方几次和k二进制位数有关系
            a = a * a;
        }
        return res;
    }
}
