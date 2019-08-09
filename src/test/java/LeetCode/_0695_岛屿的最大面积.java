package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * 题目描述:
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 解题思路
 * 深搜或广搜
 */
public class _0695_岛屿的最大面积 {
    @Test
    public void test1() {
        Assert.assertEquals(4, maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}}));
        Assert.assertEquals(6, maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
        Assert.assertEquals(0, maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25433812/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了91.58%的用户
     * 内存消耗 :48.3 MB, 在所有 Java 提交中击败了65.43%的用户
     */
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        int max = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if(grid[row][col] == 0) {
                    continue;
                }

                int area = dfs(grid, row, col);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 1) return 0;
        grid[r][c] = 0;
        return dfs(grid, r - 1, c) + dfs(grid, r, c - 1) + dfs(grid, r + 1, c) + dfs(grid, r, c + 1) + 1;
    }


    /**
     * https://leetcode-cn.com/submissions/detail/25433054/
     * 执行用时 :16 ms, 在所有 Java 提交中击败了12.87%的用户
     * 内存消耗 :47.2 MB, 在所有 Java 提交中击败了67.84%的用户
     */
    public int maxAreaOfIsland_bfs(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        int max = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if(grid[row][col] == 0) {
                    continue;
                }

                int area = 0;
                Deque<Integer> deque = new ArrayDeque<>();
                deque.push(encode(row, col));
                while (deque.size() > 0) {
                    Integer pos = deque.pop();
                    int r = decodeX(pos), c = decodeY(pos);
                    if(grid[r][c] == 1) {
                        grid[r][c] = 0;
                        area++;
                    }

                    if (r - 1 >= 0 && grid[r - 1][c] == 1) deque.push(encode(r - 1, c));
                    if (c - 1 >= 0 && grid[r][c - 1] == 1) deque.push(encode(r, c - 1));
                    if (r + 1 < grid.length && grid[r + 1][c] == 1) deque.push(encode(r + 1, c));
                    if (c + 1 < grid[r].length && grid[r][c + 1] == 1) deque.push(encode(r, c + 1));

                }
                max = Math.max(max, area);
            }
        }
        return max;
    }
    public int encode(int x, int y) {
        return (x << 8) + y;
    }

    public int decodeX(int enc) {
        return enc >> 8;
    }

    public int decodeY(int enc) {
        return enc & 0xff;
    }
}
