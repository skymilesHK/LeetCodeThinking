package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 895. 最大频率栈
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 *
 * FreqStack 有两个函数：
 *
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 *
 *
 * 示例：
 *
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 *
 * pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。
 *
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 * 栈变成 [5,7,5,4]。
 *
 * pop() -> 返回 5 。
 * 栈变成 [5,7,4]。
 *
 * pop() -> 返回 4 。
 * 栈变成 [5,7]。
 *
 *
 * 提示：
 *
 * 对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。
 * 如果栈的元素数目为零，则保证不会调用  FreqStack.pop()。
 * 单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。
 * 单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。
 * 所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。
 */
public class LeetCode895 {

    class Triple {
        int value;
        int cnt;
        int id;

        public Triple(int value, int cnt, int id) {
            this.value = value;
            this.cnt = cnt;
            this.id = id;
        }
    }

    private int id;
    // 建立一个哈希表，用来记录每个数字出现的次数
    private Map<Integer, Integer> map;
    // 建立一个大根堆，每个元素是个三元组 出现次数，插入时间，数字。如果出现次数相同，则插入时间大的优先。设置时间戳记录插入时间。
    private PriorityQueue<Triple> maxHeap;

    public LeetCode895() {
        map = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.cnt == b.cnt) {
                return b.id - a.id;
            } else {
                return b.cnt - a.cnt;
            }
        });
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxHeap.offer(new Triple(val, map.get(val), id++));
    }

    public int pop() {
        Triple t = maxHeap.poll();
        map.put(t.value, map.getOrDefault(t.value, 0) - 1);
        return t.value;
    }
}
