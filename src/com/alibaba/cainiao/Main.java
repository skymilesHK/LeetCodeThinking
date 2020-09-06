package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        LeetCode438 leetCode = new LeetCode438();
        List<Integer> anagrams = leetCode.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

}
