package com.alibaba.cainiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies
 * Easy
 *
 * 495
 *
 * 890
 *
 * Add to List
 *
 * Share
 * You have n candies, the ith candy is of type candies[i].
 *
 * You want to distribute the candies equally between a sister and a brother so that each of them gets n / 2 candies (n is even). The sister loves to collect different types of candies, so you want to give her the maximum number of different types of candies.
 *
 * Return the maximum number of different types of candies you can give to the sister.
 *
 *
 *
 * Example 1:
 *
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 * Example 2:
 *
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * Example 3:
 *
 * Input: candies = [1,1]
 * Output: 1
 * Example 4:
 *
 * Input: candies = [1,11]
 * Output: 1
 * Example 5:
 *
 * Input: candies = [2,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == candies.length
 * 2 <= n <= 10^4
 * n is even.
 * -10^5 <= candies[i] <= 10^5
 */
public class LeetCode575 {

    // https://www.cnblogs.com/zhiyin1209/p/12913208.html
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(candies[i]);
        }

        if (set.size() >= n / 2) {
            return n / 2;
        } else {
            return set.size();
        }
    }

}
