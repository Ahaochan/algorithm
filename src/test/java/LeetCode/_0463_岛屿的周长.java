package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/island-perimeter/
 * 题目描述:
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 解题思路
 */
public class _0463_岛屿的周长 {
    @Test
    public void test1() {
        int[][] grid = {{0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}};

        Assert.assertEquals(16, islandPerimeter(grid));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19805800/
     * 执行用时 : 32 ms, 在Island Perimeter的Java提交中击败了88.50% 的用户
     * 内存消耗 : 69.9 MB, 在Island Perimeter的Java提交中击败了74.30% 的用户
     */
    public int islandPerimeter(int[][] grid) {
        int land = 0, repeat = 0;
        for (int row = 0, rowLen = grid.length; row < rowLen; row++) {
            for (int col = 0, colLen = grid[row].length; col < colLen; col++) {
                // 1. 跳过非陆地
                if(grid[row][col] != 1) {
                    continue;
                }

                // 2. 统计陆地数量
                land++;
                // 3. 统计接驳的边的数量
                if(row + 1 < rowLen && grid[row + 1][col] == 1) {
                    repeat++;
                }
                if(col + 1 < colLen && grid[row][col + 1] == 1) {
                    repeat++;
                }

            }
        }
//        return land * 4 - repeat * 2;
        return (land << 2) - (repeat << 1);
    }
}
