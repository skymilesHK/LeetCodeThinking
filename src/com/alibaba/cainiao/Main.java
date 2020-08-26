package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LeetCode97 leetCode = new LeetCode97();
        boolean s = leetCode.isInterleave("db", "b", "cbb");
        System.out.println(s);
    }

}
