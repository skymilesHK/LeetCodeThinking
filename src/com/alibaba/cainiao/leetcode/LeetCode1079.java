package com.alibaba.cainiao.leetcode;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.Set;

/**
 * 1079. Letter Tile Possibilities
 * Medium
 *
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 *
 *
 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */
public class LeetCode1079 {

    boolean[] visited = null;
    Set<String> set = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        visited = new boolean[tiles.length()];
        dfs(tiles, "");
        set.remove("");
        return set.size();
    }

    private void dfs(String tiles, String path) {
        set.add(path);
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(tiles, path + tiles.charAt(i));
                visited[i] = false;
            }
        }
    }

}
