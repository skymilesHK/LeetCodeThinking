package com.alibaba.cainiao.leetcode;

/**
 * 289. Game of Life
 * https://leetcode-cn.com/problems/game-of-life/
 */
public class LeetCode289 {
    // // https://www.youtube.com/watch?v=9AsUixzUGa0&t=203s
    // 标记 die -> live : -1
    // 标记 live -> die : -2
    // countLives():数8个方向的活着细胞数
    // update: -1->1, -2->0
    int[] dx = {-1, 0, 1, 0, 1, -1, 1, -1};
    int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    int m = 0;
    int n = 0;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        if (m == 0) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    int lives = countLives(board, i, j);
                    if (lives == 3) {
                        board[i][j] = -1;
                    }
                } else if (board[i][j] == 1) {
                    int lives = countLives(board, i, j);
                    if (lives < 2 || lives > 3) {
                        board[i][j] = -2;
                    }
                }
            }
        }

        update(board);
    }

    private int countLives(int[][] board, int row, int col) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == -2)) {
                res++;
            }

        }
        return res;
    }

    private void update(int[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
