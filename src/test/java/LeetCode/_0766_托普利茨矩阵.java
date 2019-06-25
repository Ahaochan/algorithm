package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 * 题目描述:
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 解题思路
 * 遍历每一行, 和左上角的元素对比, 如果不一致就直接 return false
 */
public class _0766_托普利茨矩阵 {
    @Test
    public void test1() {
        Assert.assertTrue(isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}}));
        Assert.assertFalse(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21333489/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了91.14%的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了91.67%的用户
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if(matrix[r][c] != matrix[r-1][c-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21332626/
     * 执行用时 :5 ms, 在所有 Java 提交中击败了26.14%的用户
     * 内存消耗 :45.1 MB, 在所有 Java 提交中击败了71.93%的用户
     */
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int rowLen = matrix.length;

        int row = rowLen - 1, col = 0;
        while (row != 0 || col != matrix[0].length) {
            int num = matrix[row][col];

            for (int r = 1; row + r < rowLen && col + r < matrix[row + r].length; r++) {
                if(matrix[row + r][col + r] != num) {
                    return false;
                }
            }

            if(row > 0) {
                row--;
            } else {
                col++;
            }
        }

        return true;
    }
}
