package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
//        int[] a = {89,62,70,58,47,47,46,76,100,70};

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

        List<Integer> C = null;
        if (greater(A, B)) {
            C = sub(A, B);
        } else {
            C = sub(B, A);
            System.out.print("-");
        }
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print((C.get(i)));
        }
    }

    // A.size() >= B.size()
    private static List<Integer> sub(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        // t是上一个低位是不是有借位
        int t = 0;

        for (int i = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) {
                t = t - B.get(i);
            }
            // 如果t>=0,那么结果就是t本身,如果t<0,那么要借一位,t+10,综上就是 (t + 10) % 10
            C.add((t + 10) % 10);
            if (t < 0) {
                t = 1;
            } else {
                t = 0;
            }
        }

        // remove leading zeros
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }

    private static boolean greater(List<Integer> A, List<Integer>  B) {
        if (A.size() != B.size()) {
            return A.size() > B.size();
        }

        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i).intValue() != B.get(i).intValue()) {
                return A.get(i) > B.get(i);
            }
        }

        return true;
    }

}
