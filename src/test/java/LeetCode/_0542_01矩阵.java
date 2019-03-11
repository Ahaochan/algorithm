package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 * 题目描述:
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 解题思路
 * 动态规划, 分两次遍历, 从左上往右下, 从右下往左上.
 * 左上往右下: dp[row][col] = matrix[row][col] == 0 ? 0 :                   min(dp[row-1][col], dp[row][col-1]) + 1;
 * 右下往左上: dp[row][col] = matrix[row][col] == 0 ? 0 : min(dp[row][col], min(dp[row+1][col], dp[row][col+1]) + 1);
 *
 */
public class _0542_01矩阵 {
    @Test
    public void test1() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] expect = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Assert.assertArrayEquals(expect, updateMatrix(matrix));
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] expect = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };
        Assert.assertArrayEquals(expect, updateMatrix(matrix));
    }
    @Test
    public void test3() {
        int[][] matrix = {{0}, {0}, {0}, {0}, {0}};
        int[][] expect = {{0}, {0}, {0}, {0}, {0}};
        Assert.assertArrayEquals(expect, updateMatrix(matrix));
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};
        int[][] expect = {
                {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}};
        Assert.assertArrayEquals(expect, updateMatrix(matrix));
    }

    /**
     * 执行用时 : 21 ms, 在01 Matrix的Java提交中击败了88.56% 的用户
     * 内存消耗 : 68.8 MB, 在01 Matrix的Java提交中击败了25.53% 的用户
     */
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int rowLen = matrix.length, colLen = matrix[0].length;

        // 1. 从左上往右下扫描, 只对比左和上
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                // 1.1. 为 0 则 0
                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                }
                // 1.2. 最左上角的, 对比不了, 则赋最大值, >>1 是为了避免溢出, 如test4
                else if (row == 0 && col == 0) {
                    dp[row][col] = Integer.MAX_VALUE >> 1;
                }
                // 1.3. 第一行, 只对比左边
                else if (row == 0) {
                    dp[row][col] = dp[row][col - 1] + 1;
                }
                // 1.4. 第一列, 只对比上边
                else if (col == 0) {
                    dp[row][col] = dp[row - 1][col] + 1;
                }
                // 1.5. 其他则对比左边和上边
                else {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                }
            }
        }

        // 2. 从右下往左上扫描, 只对比右和下
        for (int row = rowLen - 1; row >= 0; row--) {
            for (int col = colLen - 1; col >= 0; col--) {
                // 2.1. 为 0 则 0
                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                }
                // 2.2. 最右下角的, 对比不了, 则跳过
                else if (row == rowLen - 1 && col == colLen - 1) {
                    // 跳过
                }
                // 2.3. 最后一行, 只对比右边
                else if (row == rowLen - 1) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][col + 1]+1);
                }
                // 2.4. 最后一列, 只对比下边
                else if (col == colLen - 1) {
                    dp[row][col] = Math.min(dp[row][col], dp[row + 1][col]+1);
                }
                // 2.5. 其他则对比右边和下边
                else {
                    dp[row][col] = Math.min(dp[row][col], Math.min(dp[row + 1][col], dp[row][col + 1]) + 1);
                }
            }
        }

        return dp;
    }
}
