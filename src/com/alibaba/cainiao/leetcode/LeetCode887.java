package com.alibaba.cainiao.leetcode;

/**
 * 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class LeetCode887 {

    //备忘录
    int[][] memo = new int[200][20000];

    // https://leetcode-cn.com/problems/super-egg-drop/solution/887-ji-dan-diao-luo-by-dyzahng-hc9k/
    public int superEggDrop(int K, int N) {
        // 函数含义：有K个鸡蛋、N层楼，在最坏的情况下，至少需要扔鸡蛋的次数。
        return dfs(K, N);
    }

    private int dfs(int K, int N) {
        // 查看备忘录，有记录则跳过
        if (memo[K][N] != 0) {
            return memo[K][N];
        }

        // 只有一个鸡蛋，至少需要扔n次
        if (K == 1) {
            return N;
        }

        // 已经扔到最后一层楼了，则不需要扔了，返回0
        if (N == 0) {
            return 0;
        }

        // 初始化返回值，因为需要比较最小值
        int res = Integer.MAX_VALUE;
        int start = 1, end = N, mid = 1;
        /**
         *  二分搜索遍历1...n层
         */
        while (start <= end) {
            mid = start + (end - start) / 2;
            /** 在当前楼层i处鸡蛋破了，
             * 那么需要递归遍历剩下的1..i-1层共i-1层，
             * 鸡蛋个数也需要减1变为k-1个。
             */
            int broken = dfs(K - 1, mid - 1);
            /** 在当前楼层i处鸡蛋没破，
             * 那么需要递归遍历剩下的i+1...n层共n-i层，
             * 鸡蛋个数不需要减1还为k个。
             */
            int notbroken = dfs(K, N - mid);
            // 考虑到题目要求最坏情况下，则需要取两者中的较大值
            if (broken > notbroken) {
                end = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                start = mid + 1;
                res = Math.min(res, notbroken + 1);
            }
        }
        /* 更新备忘录 */
        memo[K][N] = res;
        /* 返回当前k个鸡蛋、n层楼的结果 */
        return res;
    }

}
