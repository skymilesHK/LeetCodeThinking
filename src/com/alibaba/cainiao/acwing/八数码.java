package com.alibaba.cainiao.acwing;

import java.util.*;

public class 八数码 {
    // https://www.acwing.com/solution/content/35528/
    // https://www.acwing.com/activity/content/code/content/208107/java

    static String end = "12345678x";
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[] op = {'u', 'r', 'd', 'l'};
    static Queue<String> q = new ArrayDeque<>();
    static Map<String, Integer> dist = new HashMap<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(in.next());
        }

        bfs(sb.toString());
    }

    private static void bfs(String start) {
        q.offer(start);
        dist.put(start, 0);
        while (!q.isEmpty()) {
            String t = q.poll();
            if (end.equals(t)) {
                System.out.println(dist.get(t));
                return;
            }

            // 查找x的位置，遍历x的四周各个候选字符，开始转移
            // 1维下标
            int k = t.indexOf('x');
            // 2维下标
            int x = k / 3, y = k % 3;

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    // 2维转1维
                    char[] newChars = t.toCharArray();
                    swap(newChars, k, a * 3 + b);
                    String newStr = new String(newChars);
                    // 不在dist中，说明没有visit过,更新距离
                    if (!dist.containsKey(newStr)) {
                        q.offer(newStr);
                        dist.put(newStr, dist.get(t) + 1);
                    }

                }
            }
        }
        System.out.print("-1");
    }

    private static void swap(char[] a, int i, int j) {
        if (i == j) {
            return;
        }
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
