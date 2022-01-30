package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Scanner;

public class 小国王 {
    // https://www.acwing.com/solution/content/56419/
    // https://www.acwing.com/solution/content/56348/

    // y总在视频中说的是 状态 ，但实际上代码体现的是采取 状态对应的下标 (相信很多小伙伴和我一样也懵逼了很久) 于是在此说明一下为什么这样也是对的 ：
    // 我们并不用去关心状态到底是什么 因为我们已经将状态都预处理好了 所有只用状态的下标来进行转移也是对的

    static int N = 11, K = N * N, M = 1 << N;
    static int n, k;
    // dp[i][j][k]代表 考虑前 i 层的棋盘，前 i 层放置了共 j 个国王，且第 i 层状态是 k 的方案
    static int[][][] dp = new int[N][K][M];
    // 每个状态中所存放的国王个数, 例如状态10001中1的数量为2
    static int[] cnts = new int[N];
    /**
     * head[i]存放下标为i的状态所能转移到的状态下标
     * 例如:
     * a: 10000001
     *
     * b:
     * 1.  00101000
     * 2.  00100100
     * 所以head[10000001]={00100100,00101000}
     */
    static ArrayList<Integer>[] head = new ArrayList[1 << N];
    // state则存放所有合法的状态,如:10010和101010
    static ArrayList<Integer> states = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();

        // 只预处理出合法的状态过程,行内不能相互攻击到
        for (int s = 0; s < 1 << n; s++) {  // 遍历本行中所有可能的状态下标
            if (check(s)) {
                states.add(s);
                cnts[s] = count(s);
            }
        }

        // 只预处理所有合法状态的合法转移,相邻行之间不能相互攻击到
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < states.size(); j++) {
                // i,j是状态下标，a，b是状态
                int a = states.get(i), b = states.get(j);
                if ((a & b) == 0 && check(a | b)) {
                    if (head[i] == null) {
                        head[i] = new ArrayList<>();
                    }
                    head[i].add(j);
                }
            }
        }

        // 什么也不做的时候也算一种合法方案
        dp[0][0][0] = 1;
        // 从第1行开始遍历遍历到n + 1行(是一步为了最后不用枚举答案的小优化)
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j <= k; j++) {
                for (int aIdx = 0; aIdx < states.size(); aIdx++) {
                    // aIdx, bIdx是状态下标
                    ArrayList<Integer> bList = head[aIdx];
                    for (Integer bIdx : bList) {
                        Integer a = states.get(aIdx);
                        // 状态a所放的国王数
                        int count = cnts[a];
                        if (j >= count) {
                            // b状态转移到a状态
                            dp[i][j][aIdx] += dp[i - 1][j - count][bIdx];
                        }
                    }
                }
            }
        }

        // 输出到n + 1行, 已经放了m个国王, 当前最后一行的状态下标为0的合法方案数
        System.out.println(dp[n + 1][k][0]);

    }

    private static int count(int state) {
        int res = 0;
        for (int i = 0; i < n; i ++ ) {
            res += (state >> i) & 1;
        }
        return res;
    }

    // 检查该下标对应的状态中是否没有相邻的1
    static boolean check(int state) {
        for (int i = 0; i < n - 1; i++) {
            if (((state >> i & 1) & (state >> (i + 1) & 1)) == 1) {
                return false;
            }
        }
        return true;
    }

}
