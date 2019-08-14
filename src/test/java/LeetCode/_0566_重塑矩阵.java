package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 * 题目描述:
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 解题思路
 */
public class _0566_重塑矩阵 {
    @Test
    public void test1() {
        int[][] nums = {{1,2},{3,4}};
        int[][] expect = {{1,2,3,4}};
        Assert.assertArrayEquals(expect, matrixReshape(nums, 1,4));
    }

    @Test
    public void test2() {
        int[][] nums = {{1,2},{3,4}};
        Assert.assertArrayEquals(nums, matrixReshape(nums, 2,4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25917770/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了90.05%的用户
     * 内存消耗 :51.2 MB, 在所有 Java 提交中击败了42.45%的用户
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldRowLen = nums.length, oleColLen = nums[0].length;
        int size = r * c;
        if(oldRowLen * oleColLen != size) {
            return nums;
        }

        int[][] result = new int[r][c];
        int nr = 0, nc = 0;
        for (int[] num : nums) {
            for (int i : num) {
                result[nr][nc++] = i;
                if(nc == c) {
                    nc = 0;
                    nr++;
                }
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25917313/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了30.47%的用户
     * 内存消耗 :50.8 MB, 在所有 Java 提交中击败了45.28%的用户
     */
    public int[][] matrixReshape_slow(int[][] nums, int r, int c) {
        int oldRowLen = nums.length, oleColLen = nums[0].length;
        int size = r * c;
        if(oldRowLen * oleColLen != size) {
            return nums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < size; i++) {
            int or = i / oleColLen, oc = i % oleColLen;
            int nr = i / c, nc = i % c;

            result[nr][nc] = nums[or][oc];
        }
        return result;
    }
}
