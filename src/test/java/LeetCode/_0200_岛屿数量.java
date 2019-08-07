package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 题目描述:
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 解题思路
 * 深搜或广搜
 * 每找到一个岛屿, 计数器+1, 然后将岛屿沉入水中
 *
 * 深搜比广搜快, 是因为广搜用到了Deque
 */
public class _0200_岛屿数量 {
    @Test
    public void test1() {
        char[][] islands = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(1, numIslands(islands));
    }

    @Test
    public void test2() {
        char[][] islands = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, numIslands(islands));
    }

    @Test
    public void test3() {
        char[][] islands = {
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1', '1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };
        Assert.assertEquals(1, numIslands(islands));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25146964/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了93.52%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了50.11%的用户
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] != '1') {
                    continue;
                }
                // 1. 找到一个岛屿
                count++;

                // 2. 将当前岛屿变成水域
                dfs(grid, row, col);
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != '1') return;
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25146276/
     * 执行用时 :17 ms, 在所有 Java 提交中击败了8.07%的用户
     * 内存消耗 :43.5 MB, 在所有 Java 提交中击败了32.46%的用户
     */
    public int numIslands_bfs(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] != '1') {
                    continue;
                }
                // 1. 找到一个岛屿
                count++;

                // 2. 将当前岛屿变成水域
                Deque<Integer> deque = new ArrayDeque<>();
                deque.push(encode(row, col));
                while (deque.size() > 0) {
                    Integer pos = deque.pop();
                    int r = decodeX(pos), c = decodeY(pos);
                    grid[r][c] = '0';

                    if (r - 1 >= 0 && grid[r - 1][c] == '1') deque.push(encode(r - 1, c));
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') deque.push(encode(r, c - 1));
                    if (r + 1 < grid.length && grid[r + 1][c] == '1') deque.push(encode(r + 1, c));
                    if (c + 1 < grid[r].length && grid[r][c + 1] == '1') deque.push(encode(r, c + 1));
                }
            }
        }
        return count;
    }

    public int encode(int x, int y) {
        return (x << 16) + y;
    }

    public int decodeX(int enc) {
        return enc >> 16;
    }

    public int decodeY(int enc) {
        return enc & 0xffff;
    }

}
