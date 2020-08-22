package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.LeetCode151;
import com.alibaba.cainiao.leetcode.LeetCode5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LeetCode151 leetCode = new LeetCode151();
        String reverseWords = leetCode.reverseWords("  hello world!  ");
        System.out.println(reverseWords);
    }

}
