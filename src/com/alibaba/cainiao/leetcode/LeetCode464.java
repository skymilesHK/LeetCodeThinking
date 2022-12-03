package com.alibaba.cainiao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 464. Can I Win
 * Medium
 * <p>
 * 1396
 * <p>
 * 225
 * <p>
 * Add to List
 * <p>
 * Share
 * In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.
 * <p>
 * Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 11
 * Output: false
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 * Example 2:
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 0
 * Output: true
 * Example 3:
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 1
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 */
public class LeetCode464 {

//    Map<String, Boolean> memo = new HashMap<>();
//    char[] choice = null;
//
//    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//        // (首项+尾项) * 项数 / 2
//        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
//            return false;
//        }
//
//        choice = new char[maxChoosableInteger + 1];
//        Arrays.fill(choice, '0');
//        return dfs(maxChoosableInteger, desiredTotal);
//    }
//
//    private boolean dfs(int maxChoosableInteger, int desiredTotal) {
//        String key = new String(choice);
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }
//
//        for (int i = 1; i <= maxChoosableInteger; i++) {
//            if (choice[i] == '0') {
//                choice[i] = '1';
//                if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i)) {
//                    memo.put(key, true);
//                    choice[i] = '0';
//                    return true;
//                }
//                choice[i] = '0';
//            }
//        }
//
//        memo.put(key, false);
//        return false;
//    }


    // https://www.bilibili.com/video/BV1KW411o7m2/?spm_id_from=333.337.search-card.all.click&vd_source=19a205b524ff07cbc62a6f21c0c6b7c2

    // 0: unknown, 1: can win, -1: can not win
    private byte[] cache;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // summation formula
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        cache = new byte[1 << maxChoosableInteger];

        return dfs(maxChoosableInteger, desiredTotal, 0);
    }

    /**
     * depth first search who can win!【ps: we can use combination search method instead of permutation method, so time complexity = O(2^n * n)】
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @param state               (means how many numbers are chosen using just one integer to represent)
     * @return
     */
    private boolean dfs(int maxChoosableInteger, int desiredTotal, int state) {
        if (desiredTotal <= 0) {
            return false;
        }

        if (cache[state] != 0) {
            return cache[state] == 1;
        }

        for (int i = 0; i < maxChoosableInteger; i++) {
            // number i used
            if ((state & (1 << i)) != 0) {
                continue;
            }
            // the next player can not win, current player is the winner
            if (!dfs(maxChoosableInteger, desiredTotal - (i + 1), state | (1 << i))) {
                cache[state] = 1;
                return true;
            }
        }
        cache[state] = -1;
        return false;
    }
}
