package com.alibaba.cainiao.acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 八数码 {
    // https://www.acwing.com/solution/content/35528/
    // https://www.acwing.com/activity/content/code/content/208107/java

    static String end = "12345678x";
    static Scanner in = new Scanner(System.in);
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[] op = {'u', 'r', 'd', 'l'};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String s = in.next();
            sb.append(s);
            if (!"x".equals(s)) {
                temp.append(s);
            }
        }

        // 判定是否有解
        if (!isValid(temp)) {
            System.out.print("unsolvable");
        } else {
            System.out.print(aStar(sb.toString()));
        }
    }

    private static String aStar(String start) {
        PriorityQueue<PIS> pq = new PriorityQueue<>((a, b) -> a.x - b.x);
        Map<String/**状态**/, Integer/**距离起点的距离**/> dis = new HashMap<>();
        Map<String/**当前状态**/, PSC/**上一个状态+选择**/> pre = new HashMap<>();

        pq.offer(new PIS(f(start), start));
        dis.put(start, 0);

        while (!pq.isEmpty()) {
            PIS t = pq.poll();
            String state = t.y;

            // A*出队列才是结果
            if (end.equals(state)) {
                break;
            }

            int tt = state.indexOf('x');
            int x = tt / 3;
            int y = tt % 3;

            //因为在下面state会变，所以留一个备份
            String orig = state;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                //A*允许state重复入队列
                if (a < 0 || a >= 3 || b < 0 || b >= 3) {
                    continue;
                }

                String newState = swap(state, x * 3 + y, a * 3 + b);
                // 如果没有被记录或者距离比较大需要更新
                if (!dis.containsKey(newState) || dis.get(newState) > dis.get(state) + 1) {
                    dis.put(newState, dis.get(state) + 1);
                    pq.offer(new PIS(dis.get(newState) + f(newState), newState));
                    pre.put(newState, new PSC(state, op[i]));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        String e = end;
        while (!e.equals(start)) {
            // 求出移动方案
            res.append(pre.get(e).y);
            if (pre.get(e).x.equals(start)) {
                break;
            }
            e = pre.get(e).x;
        }

        return res.reverse().toString();
    }

    /**
     * 某个点到达终点的估计距离值
     * 此处设计的估值为 当前状态各个数字到终态的对应数字处的曼哈顿距离的总和
     * @param state
     * @return
     */
    private static int f(String state) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            if (state.charAt(i) != 'x') {
                int t = state.charAt(i) - '1';
                res += Math.abs(t / 3 - i / 3) + Math.abs(t % 3 - i % 3);
            }
        }
        return res;
    }

    private static String swap(String state, int oldPod, int newPos) {
        char[] ch = state.toCharArray();
        char temp = ch[oldPod];
        ch[oldPod] = ch[newPos];
        ch[newPos] = temp;
        return String.valueOf(ch);
    }

    // 逆序对为奇数,就不可能抵达终点
    private static boolean isValid(StringBuilder str) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    cnt++;
                }
            }
        }
        return (cnt & 1) == 0;
    }

    static class PIS {
        int x;      // 状态的起点到终点的总估计值
        String y;   // 该状态

        public PIS(int x, String y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PSC {
        String x;
        char y;

        public PSC(String x, char y) {
            this.x = x;
            this.y = y;
        }
    }
}
