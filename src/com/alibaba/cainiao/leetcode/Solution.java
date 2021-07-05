package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>(32);
        ListNode cur = head;
        // 链表元素存储到集合中
        while (cur != null) {
            nums.add(cur.val);
            cur = cur.next;
        }

        int n = nums.size();

        // 递减栈
        Deque<Integer> stack = new ArrayDeque<>(nums.size());
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums.get(stack.peek()) <= nums.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == n) {
                res[i] = 0;
            } else {
                res[i] = nums.get(res[i]);
            }
        }

        return res;
    }
}