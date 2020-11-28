package com.alibaba.cainiao.leetcode;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 473. 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 *
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 */
public class LeetCode473 {
    // https://www.bilibili.com/video/av63290175 压轴题

    // 剪枝
    // 1. 从大到小枚举所有边
    // 2. 每条边的内部木棍长度从大到小填
    // 3. 如果当前木棍填充失败，那么跳过接下来所有相同长度的木棍
    // 4. 如果当前木棍填充失败，并且是当前边的第一个，则直接剪掉当前分支
    // 5. 如果当前木棍填充失败，并且是当前边的最后一个，则直接剪掉当前分支

    private int n = 0;
    private boolean[] visited = null;

    public boolean makesquare(int[] nums) {
        n = nums.length;
        visited = new boolean[n];
        nums = IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int sum = IntStream.of(nums).sum();
        if (sum % 4 != 0 || nums[0] > sum / 4) {
            return false;
        }
        // 参数：枚举每条边。每条边当前的长度，以及每条边应该最终达到的长度
        return dfs(nums, 0, 0, sum / 4);
    }

    private boolean dfs(int[] nums, int u, int curLen, int singleLen) {
        // 拼好一条边
        if (curLen == singleLen) {
            u++;
            curLen = 0;
        }
        // 拼好所有边
        if (u == 4) {
            return true;
        }

        // 尝试每个木棍
        for (int i = 0; i < n; i++) {
            if (!visited[i] && curLen + nums[i] <= singleLen) {
                visited[i] = true;
                // 加入当前边
                if (dfs(nums, u, curLen + nums[i], singleLen)) {
                    return true;
                }
                visited[i] = false;

                // 第三个剪枝,如果当前木棍填充失败，那么跳过接下来所有相同长度的木棍
                while (i + 1 < n && nums[i + 1] == nums[i]) {
                    i++;
                }

                // 第四个剪枝,如果当前木棍填充失败，并且是当前边的第一个，则直接剪掉当前分支
                if (curLen == 0) {
                    return false;
                }

                // 第五个剪枝,如果当前木棍填充失败，并且是当前边的最后一个，则直接剪掉当前分支
                if (curLen + nums[i] == singleLen) {
                    return false;
                }
            }
        }
        return false;
    }

}
