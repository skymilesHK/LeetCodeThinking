package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 高精度除法 {
    // 余数
    static int r = 0;
    static Scanner in = new Scanner(System.in);

    // A / b ，商是C，余数是r
    private static List<Integer> div(List<Integer> A, int b) {
        List<Integer> C = new ArrayList<>();
        // 注意区别，只有除法逆序
        for (int i = A.size() - 1; i >= 0; i--) {
            r = r * 10 + A.get(i);
            C.add(r / b);
            r %= b;
        }
        Collections.reverse(C);
        // remove leading zero
        while (C.size() >= 2 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }

        return C;
    }

    public static void main(String[] args) {
        String a = in.next();
        int b = in.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            A.add(a.charAt(i) - '0');
        }

        List<Integer> C = div(A, b);
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
        System.out.println();
        System.out.println(r);
    }
}
