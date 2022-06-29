package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 高精度减法 {

    // https://www.acwing.com/video/234/

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
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

        List<Integer> C = null;
        if (greater(A, B)) {
            C = sub(A, B);
        } else {
            C = sub(B, A);
            System.out.print("-");
        }

        // 逆向是高位
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
    }

    // A.size() >= B.size()
    private static List<Integer> sub(List<Integer> A, List<Integer> B) {
        int aLen = A.size();
        int bLen = B.size();
        // 借位
        int t = 0;
        ArrayList<Integer> C = new ArrayList<>();

        for (int i = 0; i < aLen; i++) {
            if (i < bLen) {
                t = A.get(i) - B.get(i) - t;
            } else {
                t = A.get(i) - t;
            }

            C.add((t + 10) % 10);
            t = t < 0 ? 1 : 0;
        }

        // remove leading 0
        while (C.size() >= 2 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }

    private static boolean greater(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) {
            return A.size() > B.size();
        }

        for (int i = A.size() - 1; i >= 0; i--) {
            if (!A.get(i).equals(B.get(i))) {
                return A.get(i) > B.get(i);
            }
        }
        return false;
    }


}
