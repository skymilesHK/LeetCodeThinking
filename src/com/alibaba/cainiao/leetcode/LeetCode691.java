package com.alibaba.cainiao.leetcode;

import java.util.HashMap;

public class LeetCode691 {

    /**
     * 输入：
     * ["with", "example", "science"], "thehat"
     *
     * 输出：
     * 3
     * @param stickers
     * @param target
     * @return
     */
    private HashMap<String, Integer> memo = new HashMap<>();
    private int n;
    private int[][] groupCnt;

    // https://leetcode.com/problems/stickers-to-spell-word/discuss/108318/C%2B%2BJavaPython-DP-%2B-Memoization-with-optimization-29-ms-(C%2B%2B)
    // https://blog.csdn.net/jackzhang_123/article/details/78891978
    public int minStickers(String[] stickers, String target) {
        n = stickers.length;
        groupCnt = new int[n][26];
        memo.put("", 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < stickers[i].length(); j++) {
                int idx = stickers[i].charAt(j) - 'a';
                groupCnt[i][idx]++;
            }
        }

        return dfs(target);
    }

    private int dfs(String target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int[] needs = new int[26];
        for (int i = 0; i < target.length(); i++) {
            needs[target.charAt(i) - 'a']++;
        }

        int res = Integer.MAX_VALUE;
        // 尝试枚举每个stickers的字符串，把符合条件的字符从target中删除，然后递归继续搜索
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            // Optimization(剪枝): If the target can be spelled out by a group of stickers,
            // at least one of them has to contain character target[0].
            // So I explicitly require next sticker containing target[0],
            // which significantly reduced the search space.
            if (groupCnt[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }

            // 每个可能的字符
            for (int j = 0; j < 26; j++) {
                if (needs[j] == 0) {
                    continue;
                }

                // 组装待下次搜索的target字符串
                for (int k = 0; k < Math.max(0, needs[j] - groupCnt[i][j]); k++) {
                    sb.append((char) (j + 'a'));
                }
            }

            String next = sb.toString();
            int t = dfs(next);
            if (t != -1) {
                res = Math.min(res, t + 1);
            }
        }

        memo.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return memo.get(target);
    }
}
