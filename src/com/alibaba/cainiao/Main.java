package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] a = {{1,2}, {1,3}, {2,4}};
        LeetCode886 leetCode = new LeetCode886();
        boolean b = leetCode.possibleBipartition(4, a);
        System.out.println(b);
    }
}