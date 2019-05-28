package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/image-smoother/
 * 题目描述:
 * 包含整数的二维矩阵 M 表示一个图片的灰度。
 * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，
 * 如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 解题思路
 * 暴力破
 * 优化思路: 可以尝试缓存值, 减少计算次数
 */
public class _0661_图片平滑器 {
    @Test
    public void test1() {
        int[][] expect = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Assert.assertArrayEquals(expect, imageSmoother(input));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19604135/
     * 执行用时 : 19 ms, 在Image Smoother的Java提交中击败了67.61% 的用户
     * 内存消耗 : 56.1 MB, 在Image Smoother的Java提交中击败了56.31% 的用户
     */
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][];
        for (int row = 0, rowLen = M.length; row < rowLen; row++) {
            int colLen = M[row].length;
            result[row] = new int[colLen];
            boolean top  = row - 1 >= 0, down = row + 1 < rowLen;

            for (int col = 0; col < colLen; col++) {
                boolean left = col - 1 >= 0, right = col + 1 < colLen;

                double value = 0, num = 0;
                if(top) {
                    if(left) {value += M[row - 1][col - 1]; num++;}
                    value += M[row - 1][col]; num++;
                    if(right) {value += M[row - 1][col + 1]; num++;}
                }

                if(left) {value += M[row][col - 1]; num++;}
                value += M[row][col]; num++;
                if(right) {value += M[row][col + 1]; num++;}

                if(down) {
                    if(left) {value += M[row + 1][col - 1]; num++;}
                    value += M[row + 1][col]; num++;
                    if(right) {value += M[row + 1][col + 1]; num++;}
                }

                result[row][col] = (int) (value / num);
            }
        }
        return result;
    }
}
