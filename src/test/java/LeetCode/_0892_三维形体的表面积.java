package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * 题目描述:
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 *
 * 解题思路
 */
public class _0892_三维形体的表面积 {
    @Test
    public void test1() {
        Assert.assertEquals(10, surfaceArea(new int[][]{{2}}));
        Assert.assertEquals(34, surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        Assert.assertEquals(16, surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        Assert.assertEquals(32, surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        Assert.assertEquals(46, surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23982076/
     * 执行用时 :5 ms, 在所有 Java 提交中击败了95.88%的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了75.31%的用户
     */
    public int surfaceArea(int[][] grid) {
        int xy = 0, yz = 0, xz = 0;

        for (int i = 0; i < grid.length; i++) {
            int allRowHigh = 0;
            int allColHigh = 0;
            int preRowHigh = 0;
            int preColumnHigh = 0;

            for (int j = 0; j < grid.length; j++) {
                // 1. 加上下的面积
                if (grid[i][j] > 0) {
                    xy++;
                }

                // 2. 统计一行的纵向面积 yz
                allRowHigh += Math.abs(grid[i][j] - preRowHigh);
                preRowHigh = grid[i][j];

                // 3. 统计一列的纵向面积 xz
                allColHigh += Math.abs(grid[j][i] - preColumnHigh);
                preColumnHigh = grid[j][i];
            }

            allRowHigh += grid[i][grid.length - 1];
            allColHigh += grid[grid.length - 1][i];

            yz += allRowHigh;
            xz += allColHigh;
        }

        return xy * 2 + yz + xz;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23974313/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了30.00%的用户
     * 内存消耗 :38.7 MB, 在所有 Java 提交中击败了96.30%的用户
     */
    public int surfaceArea_slow(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;

        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int area = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if(grid[row][col] > 0) {
                    // 1. 加上下的面积
                    area+=2;

                    // 2. 四方向搜索
                    for (int d = 0; d < 4; d++) {
                        int r = row + dr[d];
                        int c = col + dc[d];
                        int nv = 0;
                        if (0 <= r && r < rowLen && 0 <= c && c < colLen)
                            nv = grid[r][c];

                        // 3. 如果比周围的高, 则减去被遮挡的部分
                        area += Math.max(grid[row][col] - nv, 0);
                    }
                }
            }
        }

        return area;
    }

}
