package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * 题目描述:
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 * 投影就像影子，将三维形体映射到一个二维平面上。
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回所有三个投影的总面积。
 *
 * 解题思路
 * 关键点是: 找到每一行的最高点, 每一列的最高点.
 */
public class _0883_三维形体投影面积 {
    @Test
    public void test1() {
        Assert.assertEquals(5, projectionArea(new int[][]{{2}}));
        Assert.assertEquals(17, projectionArea(new int[][]{{1, 2}, {3, 4}}));
        Assert.assertEquals(8, projectionArea(new int[][]{{1, 0}, {0, 2}}));
        Assert.assertEquals(14, projectionArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        Assert.assertEquals(21, projectionArea(new int[][]{{2,2,2},{2,1,2},{2,2,2}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21266190/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了78.80%的用户
     * 内存消耗 :41.1 MB, 在所有 Java 提交中击败了49.50%的用户
     */
    public int projectionArea(int[][] grid) {
        int len = grid.length;
        int[] maxX = new int[len], maxY = new int[len];
        int area = 0;
        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                int v = grid[x][y];
                maxX[x] = Math.max(maxX[x], v);
                maxY[y] = Math.max(maxY[y], v);
                if(v > 0) {
                    area++;
                }
            }
        }


        for (int v : maxX) {
            area += v;
        }
        for (int v : maxY) {
            area += v;
        }
        return area;
    }
}
