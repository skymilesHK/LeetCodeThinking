package com.alibaba.cainiao.leetcode;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class LeetCode79 {

    int m = 0, n = 0;
    boolean[][] visited = null;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        if (m == 0) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 从row，col点开始4个方向遍历，从word中第indexOfWord位开始匹配,得到结果
     * @param board
     * @param row
     * @param column
     * @param word
     * @param indexOfWord
     * @return
     */
    private boolean dfs(char[][] board, int row, int column, String word, int indexOfWord) {
        if (indexOfWord == word.length()) {
            return board[row][column] == word.charAt(indexOfWord);
        }

        visited[row][column] = true;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = column + dy[i];
            if (x >=0 && x < m && y >= 0 && y < n && board[x][y] == word.charAt(indexOfWord) && !visited[x][y]) {
                if (dfs(board, x, y, word, indexOfWord + 1)) {
                    return true;
                }
            }
        }
        visited[row][column] = false;
        return false;
    }

}
