package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 *
 *
 * 提示：
 *
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *
 *
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 *
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class LeetCode332 {

    // https://zhuanlan.zhihu.com/p/37693521
    // https://www.youtube.com/watch?v=LKSdX31pXjY
    // 欧拉路径
    Map<String/**起点**/, PriorityQueue<String> /**终点列表**/> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
//            map.computeIfAbsent(from, k -> new PriorityQueue<>());
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(to);

            // 新的目的地to
            map.get(from).offer(to);
        }

        // Hierholzer
        dfs("JFK");
        return res;
    }

    private void dfs(String s) {
        PriorityQueue<String> pq = map.get(s);
        // 没有访问的边
        if (pq != null && !pq.isEmpty()) {
            // 访问下边=从pq poll
            dfs(pq.poll());
        }

        res.addFirst(s);
    }

}
