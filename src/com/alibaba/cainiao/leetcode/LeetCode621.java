package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 621. Task Scheduler
 * Medium
 *
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 *
 *
 * Constraints:
 *
 * 1 <= task.length <= 104
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 */
public class LeetCode621 {
    // 0.要再次执行同一任务，CPU必须等待时间n，因此我们可以认为好像有一个周期为n + 1的周期，无论您是否在周期中安排其他任务。
    //
    // 1.为了避免让CPU只能选择有限的任务，并且最后不得不经常坐在那里散热，至关重要的是，尽可能长时间地保持任务池的多样性。
    // 2.为此，我们应该尝试安排CPU在任何时候总是尝试在最流行的任务之间进行轮循。
    public int leastInterval(char[] tasks, int n) {
        // Map<task, count>
        Map<Character, Integer> map = new HashMap<>(tasks.length);
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        // max heap <task, count>
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        int allTime = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            List<Integer> workList = new ArrayList<>(tasks.length);
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    workList.add(pq.poll());
                }
            }
            for (int cnt : workList) {
                if (--cnt > 0) {
                    pq.offer(cnt);
                }
            }
            allTime += !pq.isEmpty() ? cycle : workList.size();
        }

        return allTime;
    }
}
