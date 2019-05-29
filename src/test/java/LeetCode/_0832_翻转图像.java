package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/flipping-an-image/
 * 题目描述:
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 解题思路
 * 模拟题, 照着流程走就行了
 */
public class _0832_翻转图像 {
    @Test
    public void test1() {
        int[][] input = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] expect = {{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Assert.assertArrayEquals(expect, flipAndInvertImage(input));
    }

    @Test
    public void test2() {
        int[][] input = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] expect = {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}};
        Assert.assertArrayEquals(expect, flipAndInvertImage(input));
    }

    /**
     * 执行用时 : 2 ms, 在Flipping an Image的Java提交中击败了82.54% 的用户
     * 内存消耗 : 37.8 MB, 在Flipping an Image的Java提交中击败了91.71% 的用户
     */
    public int[][] flipAndInvertImage(int[][] A) {
        // 1. 遍历每行
        for (int row = 0, rowLen = A.length; row < rowLen; row++) {
            // 2. 二分调换位置
            int left = 0, right = A[row].length - 1;
            while (left <= right) {
                // 3. 翻转并反转
                int tmp = A[row][left];
                A[row][left] = A[row][right] == 0 ? 1 : 0;
                A[row][right] = tmp == 0 ? 1 : 0;
                left++;right--;
            }
        }
        return A;
    }
}
