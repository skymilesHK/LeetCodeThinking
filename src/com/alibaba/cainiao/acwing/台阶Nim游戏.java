package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 台阶Nim游戏 {

    static Scanner in = new Scanner(System.in);

    // 如果先手时奇数台阶上的值的异或值为0，则先手必败，反之必胜
    public static void main(String[] args){

        int n = in.nextInt();
        int res = 0;
        for(int i = 1 ; i <= n ; i ++ ){
            int x = in.nextInt();
            if(i % 2 == 1){ // 只需要管奇数级台阶上的异或值
                res ^= x;
            }
        }
        if(res > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
