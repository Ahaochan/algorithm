package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/game-of-life/
 * 题目描述:
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 解题思路
 * 要求在原数组做变更, 那么就要扩展状态码, 不能单纯的 0, 1
 * 我们用两位二进制, 表示状态的变更
 * 00 死变死, 01活变死, 10死变活, 11活变活
 * 那么
 * 判断变更前的细胞是否为活 (status & 01) > 0
 * 判断变更后的细胞是否为活 (status & 10) > 0
 */
public class _0289_生命游戏 {
    @Test
    public void test1() {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
        Assert.assertArrayEquals(new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}
        }, board);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25455108/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.11%的用户
     * 内存消耗 :35.4 MB, 在所有 Java 提交中击败了54.82%的用户
     */
    public void gameOfLife(int[][] board) {
        int rowLen = board.length, colLen = board[0].length;

        // 1. 遍历每个细胞
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {

                // 2. 统计每个细胞周围的活细胞数量
                int count = aliveCount(board, row, col);

                // 3. 模拟
                // 3.1. 少于两个细胞, 细胞变死
                if(count < 2) {
                    board[row][col] &= 0b01;
                }
                // 3.2. 两个细胞, 细胞保持活性
                else if(count == 2 && isAlive(board[row][col])) {
                    board[row][col] |= 0b10;
                }
                // 3.3. 三个细胞, 细胞复活
                else if(count == 3){
                    board[row][col] |= 0b10;
                }
                // 3.4. 大于三个细胞, 细胞变死
                else {
                    board[row][col] &= 0b01;
                }
            }
        }

        // 4. 变更细胞状态
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                board[row][col] = doAlive(board[row][col]) ? 1 : 0;
            }
        }
    }

    private int aliveCount(int[][] board, int row, int col) {
        int count = 0;
        int rowLen = board.length, colLen = board[row].length;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if(r == row && c == col) {
                    continue;
                }

                if(r >= 0 && c >= 0 && r < rowLen && c < colLen && isAlive(board[r][c])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isAlive(int val) {
        return (val & 0b01) > 0;
    }
    private boolean doAlive(int val) {
        return (val & 0b10) > 0;
    }
}
