package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/transpose-matrix/
 * 题目描述:
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 解题思路
 * 暴力for
 */
public class _0867_转置矩阵 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.assertArrayEquals(new int[][]{{1, 4}, {2, 5}, {3, 6}}, transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21337024/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.59%的用户
     * 内存消耗 :48.8 MB, 在所有 Java 提交中击败了60.96%的用户
     */
    public int[][] transpose(int[][] A) {
        int rowLen = A.length, colLen = A[0].length;
        int[][] result = new int[colLen][rowLen];

        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                result[c][r] = A[r][c];
            }
        }
        return result;
    }
}
