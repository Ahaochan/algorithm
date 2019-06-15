package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * 题目描述:
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *     A.length >= 3
 *     在 0 < i < A.length - 1 条件下，存在 i 使得：
 *          A[0] < A[1] < ... A[i-1] < A[i]
 *          A[i] > A[i+1] > ... > A[B.length - 1]、
 *
 * 解题思路
 * for循环遍历即可
 */
public class _0941_有效的山脉数组 {
    @Test
    public void test1() {
        Assert.assertFalse(validMountainArray(2, 1));
        Assert.assertFalse(validMountainArray(3, 5, 5));
        Assert.assertTrue(validMountainArray(0, 3, 2, 1));
        Assert.assertFalse(validMountainArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertFalse(validMountainArray(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20702709/
     * 执行用时 :3 ms, 在所有Java提交中击败了94.72%的用户
     * 内存消耗 :48.4 MB, 在所有Java提交中击败了40.37%的用户
     */
    public boolean validMountainArray(int... A) {
        int len = A.length;
        if(len < 3) {
            return false;
        }

        // 1. 上山
        int mid = 1;
        while (mid < len && A[mid-1] < A[mid]){ mid++; }
        if(len == mid || mid == 1) {
            return false; // 单调递增减则false
        }

        // 2. 下山
        while (mid < len) {
            if(A[mid-1] <= A[mid]) {
                return false; // 有两个峰顶则false
            }
            mid++;
        }
        return true;
    }
}
