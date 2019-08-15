package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/rotate-image/submissions/
 * 题目描述:
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 解题思路
 * 最简单的方法就是模拟
 *
 * 先看第一种方法, 假设有矩阵
 *           5  1  9 11
 *           2  4  8 10
 *          13  3  6  7
 *          15 14 12 16
 * 我们先水平翻转矩阵
 *          11  9  1  5
 *          10  8  4  2
 *           7  6  3 13
 *          16 12 14 15
 * 然后沿对角线对折即可
 *          15 13  2  5
 *          14  3  4  1
 *          12  6  8  9
 *          16  7 10 11
 * 这种方法比较简单, 实现也简单, 但是交换了两次, 效率低
 *
 * 我们可以直接模拟交换
 * 假设有矩阵
 *           5  1  9 11
 *           2  4  8 10
 *          13  3  6  7
 *          15 14 12 16
 * 我们翻转第一个数字
 *          15  1  9  5
 *           2  4  8 10
 *          13  3  6  7
 *          16 14 12 11
 * 我们翻转第二个数字
 *          15 13  9  5
 *           2  4  8  1
 *          12  3  6  7
 *          16 14 10 11
 * 这样翻转就只用翻转一次, 但是实现就比较麻烦, 要计算对应数字的位置
 *
 */
public class _0048_旋转图像 {
    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expect = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        rotate(matrix);
        Assert.assertArrayEquals(expect, matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expect = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        rotate(matrix);
        Assert.assertArrayEquals(expect, matrix);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26022090/
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了58.92%的用户
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int round = 0, roundLen = n / 2; round < roundLen; round++) {

            for (int topIdx = round, len = n - 1 - round; topIdx < len; topIdx++) {

                int tmp = matrix[round][topIdx];
                matrix[round][topIdx] = matrix[n-1-topIdx][round];
                matrix[n-1-topIdx][round] = matrix[n-1-round][n-1-topIdx];
                matrix[n-1-round][n-1-topIdx] = matrix[topIdx][n-1-round];
                matrix[topIdx][n-1-round] = tmp;
            }
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26017586/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了80.17%的用户
     * 内存消耗 :35.9 MB, 在所有 Java 提交中击败了61.53%的用户
     */
    public void rotate_slow(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                int tmp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = tmp;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = n - 1 - row; col >= 0; col--) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n-1-col][n-1-row];
                matrix[n-1-col][n-1-row] = tmp;
            }
        }
    }
}
