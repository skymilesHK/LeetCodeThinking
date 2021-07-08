package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    public boolean validateStackSequences(int[] A, int[] B) {
        Deque<Integer> stack = new ArrayDeque<>();
        // push序列的下标
        // int a = 0;
        // pop序列的下标
        int b = 0;
        for (int x : A) {
            stack.push(x);
            while (!stack.isEmpty() && b < B.length && stack.peek() == B[b]) {
                stack.pop();
                b++;
            }
        }

        return b == B.length;
    }

}