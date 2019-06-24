package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 题目描述:
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 解题思路
 * 用双指针, 比较两端的绝对值大小, 再置入新数组即可
 */
public class _0977_有序数组的平方 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(-4, -1, 0, 3, 10));
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(-7, -3, 2, 3, 11));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21262634/
     * 执行用时 :5 ms, 在所有 Java 提交中击败了85.86%的用户
     * 内存消耗 :52 MB, 在所有 Java 提交中击败了47.25%的用户
     */
    public int[] sortedSquares(int... A) {
        int len = A.length;
        int[] result = new int[len];

        int l = 0, r = len - 1, idx = len - 1;
        while (l <= r) {
            result[idx--] = Math.abs(A[l]) > Math.abs(A[r]) ? A[l] * A[l++] : A[r] * A[r--];
        }
        return result;
    }
}
