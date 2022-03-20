package com.alibaba.cainiao.acwing;

import java.util.*;

public class 字串变换 {

    static int idx = 0;
    static String[] a = new String[6];                  // 规则A
    static String[] b = new String[6];                  // 规则B
    static Queue<String> qa = new ArrayDeque<>();
    static Queue<String> qb = new ArrayDeque<>();
    static Map<String, Integer> da = new HashMap<>();   // 每个状态到起点的距离da
    static Map<String, Integer> db = new HashMap<>();   // 每个状态到终点的距离db哈希表
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String A = in.next();
        String B = in.next();
        // 读入扩展规则
        while (in.hasNext()) {
            a[idx] = in.next();
            b[idx] = in.next();
            idx++;
        }

        int step = bfs(A, B);
        if (step > 10) {
            System.out.println("NO ANSWER!");
        } else {
            System.out.println(step);
        }
    }

    private static int bfs(String A, String B) {
        // qa从起点开始搜，qb从终点开始搜
        qa.offer(A);
        qb.offer(B);
        // 起点A到起点的距离为0
        da.put(A, 0);
        db.put(B, 0);

        // qa和qb都有值，说明可以扩展过来，否则说明是不相交的
        while (!qa.isEmpty() && !qb.isEmpty()) {
            int t = 0;
            if (qa.size() <= qb.size()) {
                t = extend(qa, da, db, a, b);
            } else {
                t = extend(qb, db, da, a, b);
            }
            // 如果最小步数在10步以内
            if (t <= 10) {
                return t;
            }
        }
        return 11;
    }

    /**
     * 扩展函数
     *
     * @param q  扩展的数据队列
     * @param da 到起点的距离
     * @param db 到终点的距离
     * @param a  起点规则
     * @param b  终点规则
     * @return
     */
    private static int extend(Queue<String> q, Map<String, Integer> da, Map<String, Integer> db, String[] a, String[] b) {
        String t = q.poll();    // 状态t
        for (int i = 0; i < t.length(); i++) { // t从哪里开始扩展
            for (int j = 0; j < idx; j++) {
                //如果t这个字符串的一段 = 规则里面的值，比如 abc = xu，才可以替换
                if (i + a[j].length() <= t.length() && t.substring(i, i + a[j].length()).equals(a[j])) {
                    String state = t.substring(0, i) + b[j] + t.substring(i + a[j].length());
                    if (da.containsKey(state)) {
                        continue;
                    }
                    if (db.containsKey(state)) {
                        return da.get(t) + 1 + db.get(state);
                    }
                    da.put(state, da.get(t) + 1);
                    q.add(state);
                } else{
                    continue;
                }
            }
        }
        return 11;
    }

}
