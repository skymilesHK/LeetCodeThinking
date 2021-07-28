package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 826. 安排工作以达到最大收益
 * 有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 *
 * 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 *
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 *
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 *
 * 我们能得到的最大收益是多少？
 *
 *
 *
 * 示例：
 *
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 *
 *
 * 提示:
 *
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  的范围是 [1, 10^5]
 */
public class LeetCode826 {
    // https://www.acwing.com/video/2883/
    class Task {
        int p;
        int d;

        public Task(int d, int p) {
            this.p = p;
            this.d = d;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Task[] tasks = new Task[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            Task t = new Task(difficulty[i], profit[i]);
            tasks[i] = t;
        }

        Arrays.sort(tasks, (t1, t2) -> t1.d - t2.d);
        Arrays.sort(worker);

        int res = 0, maxP = 0;
        for (int i = 0, j = 0; i < worker.length; i++) {
            while (j < tasks.length && tasks[j].d <= worker[i]) {
                maxP = Math.max(maxP, tasks[j].p);
                j++;
            }
            res += maxP;
        }

        return res;
    }
}
