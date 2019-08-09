package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/magic-squares-in-grid/
 * 题目描述:
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 * 解题思路
 * 除了暴力想不到其他的, 一看大家都是暴力我就放心了
 */
public class _0840_矩阵中的幻方 {
    @Test
    public void test1() {
        Assert.assertEquals(1, numMagicSquaresInside(new int[][]{
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25431229/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.45%的用户
     * 内存消耗 :35.1 MB, 在所有 Java 提交中击败了85.53%的用户
     */
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        int row = grid.length, col = grid[0].length;

        // 判断对角为 [i-2][j-2] ~ [i][j] 的3阶矩阵是否为幻方
        for (int i = 2; i < row; i++) {
            for (int j = 2; j < col; j++) {
                // 1. 若中间数不为5, 跳过
                if (grid[i-1][j-1] != 5)
                    continue;
                // 2. 若行、列、斜线和 存在一个不为15， 则跳过
                if ((grid[i-2][j-2]+grid[i-2][j-1]+grid[i-2][j] != 15)
                        || (grid[i-1][j-2]+grid[i-1][j] != 10)
                        || (grid[i][j-2]+grid[i][j-1]+grid[i][j] != 15)

                        || (grid[i-2][j-2]+grid[i-1][j-2]+grid[i][j-2] != 15)
                        || (grid[i-2][j-1]+grid[i][j-1] != 10)
                        || (grid[i-2][j]+grid[i-1][j]+grid[i][j] != 15)

                        || (grid[i-2][j-2]+grid[i][j] != 10)
                        || (grid[i-2][j]+grid[i][j-2] != 10)
                )
                    continue;
                // 3. 若存在小于1的数直接跳过（若有不再1～9范围的数，必存在超过9的数和小于1的数）
                if (grid[i-2][j-2]<1 || grid[i-2][j-1]<1 || grid[i-2][j]<1
                        || grid[i-1][j-2]<1 || grid[i-1][j]<1
                        || grid[i][j-2]<1 || grid[i][j-1]<1 || grid[i][j]<1)
                    continue;
                // 4. 若存在重复数跳过（此处只可能全为 5）
                if (grid[i-2][j-2] == 5)
                    continue;
                // 5. 余下情况，满足幻方
                result++;
            }
        }
        return result;
    }
}
