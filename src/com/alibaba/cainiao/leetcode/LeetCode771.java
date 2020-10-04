package com.alibaba.cainiao.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * Easy
 *
 * 2264
 *
 * 378
 *
 * Add to List
 *
 * Share
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class LeetCode771 {

    public int numJewelsInStones(String J, String S) {
        int jLen = J.length();
        int sLen = S.length();
        int res = 0;
        Set<Character> jSet = new HashSet<>();

        for (int i = 0; i < jLen; i++) {
            jSet.add(J.charAt(i));
        }

        for (int i = 0; i < sLen; i++) {
            if (jSet.contains(S.charAt(i))) {
                res++;
            }
        }

        return res;
    }

}
