package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 题目描述:
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 解题思路
 * 换个思路, 只要"逃到边缘"的 O, 就不会变成 X.
 * 那么我们只要扫描边缘的 O, 做 "染色" 操作即可.
 *
 * 可以使用 BFS 或 DFS, DFS 比较快
 */
public class _0130_被围绕的区域 {
    @Test
    public void test1() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);

        char[][] expect = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}};

        Assert.assertArrayEquals(expect, board);
    }

    @Test
    public void test2() {
        char[][] board = {};
        solve(board);
        char[][] expect = {};
        Assert.assertArrayEquals(expect, board);
    }

    @Test
    public void test3() {
        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}};
        solve(board);

        char[][] expect = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X'}};

        Assert.assertArrayEquals(expect, board);
    }

    @Test
    public void test4() {
        char[][] board = {
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},
                {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},
                {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
        solve(board);

        char[][] expect = {
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},
                {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},
                {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};

        Assert.assertArrayEquals(expect, board);
    }

    /**
     * https://leetcode-cn.com/problems/surrounded-regions/submissions/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了93.87%的用户
     * 内存消耗 :48.6 MB, 在所有 Java 提交中击败了47.20%的用户
     */
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        int rowLen = board.length, colLen = board[0].length;

        // 南北
        for (int i = 0, len = colLen; i < len; i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if(board[rowLen - 1][i] == 'O') {
                dfs(board, rowLen - 1, i);
            }
        }

        // 东西
        for (int i = 0, len = rowLen; i < len; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][colLen - 1] == 'O') {
                dfs(board, i, colLen - 1);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(board[i][j] == 'R') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O' ) return;

        board[row][col] = 'R';
        dfs(board, row-1, col);
        dfs(board, row, col-1);
        dfs(board, row+1, col);
        dfs(board, row, col+1);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23662361/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了26.09%的用户
     * 内存消耗 :49.5 MB, 在所有 Java 提交中击败了44.23%的用户
     */
    public void solve_bfs(char[][] board) {
        if(board.length == 0) {
            return;
        }
        int rowLen = board.length, colLen = board[0].length;

        // 南北
        for (int i = 0, len = colLen; i < len; i++) {
            if(board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if(board[rowLen - 1][i] == 'O') {
                bfs(board, rowLen - 1, i);
            }
        }

        // 东西
        for (int i = 0, len = rowLen; i < len; i++) {
            if(board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if(board[i][colLen - 1] == 'O') {
                bfs(board, i, colLen - 1);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(board[i][j] == 'R') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, int row, int col) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add((row << 16) + (col));
        board[row][col] = 'R';

        while (queue.size() > 0) {
            int pos = queue.poll();
            int r = pos >> 16, c = pos & 0xffff;
//            board[r][c] = 'R'; // 会造成死循环

            if(r-1 >= 0 && board[r-1][c] == 'O') {
                queue.add(((r-1) << 16) + (c));
                board[r-1][c] = 'R';
            }
            if(c-1 >= 0 && board[r][c-1] == 'O') {
                queue.add((r << 16) + (c-1));
                board[r][c-1] = 'R';
            }
            if(r+1 < board.length && board[r+1][c] == 'O') {
                queue.add(((r+1) << 16) + (c));
                board[r+1][c] = 'R';
            }
            if(c+1 < board[r].length && board[r][c+1] == 'O') {
                queue.add((r << 16) + (c+1));
                board[r][c+1] = 'R';
            }
        }
    }
}
