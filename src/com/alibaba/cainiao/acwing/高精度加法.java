package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 高精度加法 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //传进两个字符串
        String a = in.next();
        String b = in.next();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--) {
            A.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            B.add(b.charAt(i) - '0');
        }

        List<Integer> C = add(A, B);
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }

    }

    private static List<Integer> add(List<Integer> A, List<Integer> B) {
        if (A.size() < B.size()) {
            return add(B, A);
        }

        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            t += A.get(i);
            if (i < B.size()) {
                t += B.get(i);
            }
            A.set(i, t % 10);
            t /= 10;
        }

        if (t > 0) {
            A.add(t);
        }
        return A;
    }

}
