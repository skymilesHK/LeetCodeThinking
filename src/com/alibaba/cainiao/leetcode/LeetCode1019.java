package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 */
public class LeetCode1019 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // 链表元素存储到集合中
        var cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        // 栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的值是从大到小的
        Deque<Integer> stack = new ArrayDeque<>(list.size());
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(stack.peek()) <= list.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = list.size();
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == res.length) {
                res[i] = 0;
            } else {
                res[i] = list.get(res[i]);
            }
        }

        return res;
    }

}
