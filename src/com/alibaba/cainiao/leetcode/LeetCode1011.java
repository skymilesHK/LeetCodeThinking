package com.alibaba.cainiao.leetcode;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *
 *
 * 提示：
 *
 * 1 <= D <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 */
public class LeetCode1011 {
    // https://www.youtube.com/watch?v=-F2ysRiSTvk&t=339s
    public int shipWithinDays(int[] weights, int D) {
        int start = 0;
        int end = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            start = Math.min(start, weights[i]);
            end += weights[i];
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 不超过D天装载完成
            if (check(weights, mid) <= D) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (check(weights, start) <= D) {
            return start;
        } else {
            return end;
        }
    }

    // capacity是二分到了一个最大运载重量，sum是过程中累加和
    private int check(int[] weights, int capacity) {
        int days = 1, sum = 0;
        for (int x : weights) {
            if (capacity < x) {
                // 发现任意一个包裹重量都大于最大运载重量了，返回不可能搬完的天数
                return 25000009;
            }
            if (sum + x > capacity) {
                sum = x;
                // 发现过程中累加包裹重量和大于最大运载重量了，搬完的天数+1
                days++;
            } else {
                sum += x;
            }
        }

        return days;
    }

}
