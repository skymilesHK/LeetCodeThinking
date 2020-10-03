package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        int[] a = {1,2,2,4};
        LeetCode726 leetCode = new LeetCode726();
        String s = leetCode.countOfAtoms("Mg(OH)2");
        System.out.println(s);
    }

}
