package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LeetCode394 leetCode = new LeetCode394();
        String string = leetCode.decodeString("3[a]2[bc]");
        System.out.println(string);
    }
}