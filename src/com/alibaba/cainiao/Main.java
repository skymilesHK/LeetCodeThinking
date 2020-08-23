package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LeetCode929 leetCode = new LeetCode929();
        String[] a = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        int i = leetCode.numUniqueEmails(a);
        System.out.println(i);
    }

}
