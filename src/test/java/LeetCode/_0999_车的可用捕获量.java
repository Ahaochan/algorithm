package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 * 题目描述:
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * 返回车能够在一次移动中捕获到的卒的数量。
 * 
 * 解题思路
 * 先找出R点, 然后四方向搜索即可
 */
public class _0999_车的可用捕获量 {
    @Test
    public void test1() {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        Assert.assertEquals(3, numRookCaptures(board));
    }

    @Test
    public void test2() {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        Assert.assertEquals(0, numRookCaptures(board));
    }

    @Test
    public void test3() {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        Assert.assertEquals(3, numRookCaptures(board));
    }


    /**
     * 执行用时 : 1 ms, 在Available Captures for Rook的Java提交中击败了100.00% 的用户
     * 内存消耗 : 35.9 MB, 在Available Captures for Rook的Java提交中击败了100.00% 的用户
     */
    public int numRookCaptures (char[][] board){
        int row = -1, col = -1;
        int rowLen = board.length, colLen = board[0].length;

        // 1. 找出 R 点
        for (int i = 0; i < rowLen && row == -1; i++) {
            for (int j = 0; j < colLen && row == -1; j++) {
                if(board[i][j] == 'R') {
                    row = i;
                    col = j;
                }
            }
        }

        // 2. 四方向遍历
        int[][] dir = {{0,1},{0, -1},{1,0},{-1,0}};
        int count = 0;
        for(int d = 0, dirLen = dir.length; d < dirLen; d++) {
            int r = row, c = col;
            while (r >= 0 && r < rowLen && c >= 0 && c < colLen) {
                if(board[r][c] == 'B') {
                    break;
                } else if(board[r][c] == 'p') {
                    count++;
                    break;
                }
                r += dir[d][0];
                c += dir[d][1];
            }
        }
        return count;
    }
}
