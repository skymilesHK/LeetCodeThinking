package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //传进两个字符串
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();

        List<Integer> A = new ArrayList<>(a.length());
        List<Integer> B = new ArrayList<>(b.length());

        for (int i = a.length() - 1; i >= 0; i--) {
            A.add(a.charAt(i) - '0');
        }

        for (int i = b.length() - 1; i >= 0; i--) {
            B.add(b.charAt(i) - '0');
        }

        List<Integer> C = mul(A, B);

        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
    }

    private static List<Integer> mul(List<Integer> A, List<Integer> B) {
        int[] c = new int[A.size() + B.size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                c[i + j] += A.get(i) * B.get(j);
            }
        }

        // 转成List
        List<Integer> C = Arrays.stream(c).boxed().collect(Collectors.toList());

        // 进位
        int t = 0;
        for (int i = 0; i < c.length; i++) {
            t += C.get(i);
            C.set(i, t % 10);
            t = t / 10;
        }
        if (t != 0) {
            C.add(t % 10);
        }

        while (C.size() >= 2 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }

        return C;
    }

}