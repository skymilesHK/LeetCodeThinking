package com.alibaba.cainiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N = 11, l, r, K, B;
    static int[][] c = new int[N][N];
    static Scanner in = new Scanner(System.in);

    // https://www.acwing.com/solution/content/3112/
    public static void main(String[] args) {
        l = in.nextInt();
        r = in.nextInt();
        K = in.nextInt();
        B = in.nextInt();

        init();
        System.out.println(counter(r) - counter(l - 1));
    }

    private static int counter(int n) {
        if (n == 0) {
            return 0;
        }

        List<Integer> nums = new ArrayList<>(16);
        while (n > 0) {
            nums.add(n % B);
            n /= B;
        }

        int res = 0, last = 0;  // 之前那些位已经占用多少个1
        for (int i = nums.size() - 1; i >= 0; i--) {
            int x = nums.get(i);

            // 有左边分支，那么至少x>0
            if (x > 0) {
                // 第i位放0(允许先导0)
                res += c[i][K - last];
                if (x == 1) {
                    // 放1，那么后面数位上的情况不能用组合数计算，因为要保证答案中的数字比原数字要小
                    last++;
                    if (last > K) {
                        break;
                    }
                } else {
                    // 第i位可以放1, 第i位放1,后i-1位放k-last-1个1
                    if (K - last - 1 >= 0) {
                        res += c[i][K - last - 1];
                        // 对应于：左分支中填1,此时右分支的情况（右侧此时>1），不合法！！！直接break。
                        break;
                    }
                }
            }

            // 右边
            if (i == 0 && K - last == 0) {
                res++;
            }
        }

        return res;
    }

    private static void init() {
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < a; b++) {
                if (b == 0) {
                    c[a][b] = 1;
                } else {
                    c[a][b] = c[a - 1][b] + c[a - 1][b - 1];
                }
            }
        }
    }

}