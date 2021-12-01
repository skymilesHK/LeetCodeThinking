package com.alibaba.cainiao.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 试除法求约数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            List<Integer> list = getDividors(x);
            for (Integer a : list) {
                System.out.printf(a + " ");
            }
            System.out.printf("\n");
        }

    }


    static List<Integer> getDividors(int x) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                list.add(i);
                if (i != x / i) {
                    list.add(x / i);
                }
            }
        }
        list.sort((a, b) -> a - b);

        return list;

    }
}
