package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;


public class Main {

    public static void main(String[] args) {
        LeetCode686 leetCode = new LeetCode686();
        int i = leetCode.repeatedStringMatch("abcabcabcabc", "abac");
        System.out.println(i);
    }

}
