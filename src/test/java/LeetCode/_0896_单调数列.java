package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/monotonic-array/
 * 题目描述:
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 解题思路
 * 逻辑题, 理清思路即可
 */
public class _0896_单调数列 {

    @Test
    public void test1() {
        Assert.assertTrue(isMonotonic(1, 2, 2, 3));
        Assert.assertTrue(isMonotonic(6, 5, 4, 4));
        Assert.assertFalse(isMonotonic(1, 3, 2));
        Assert.assertTrue(isMonotonic(1, 2, 4, 5));
        Assert.assertTrue(isMonotonic(1, 1, 1));
        Assert.assertTrue(isMonotonic(1, 1, 2));
    }

    /**
     * 执行用时 : 6 ms, 在Monotonic Array的Java提交中击败了82.47% 的用户
     * 内存消耗 : 56 MB, 在Monotonic Array的Java提交中击败了50.64% 的用户
     */
    public boolean isMonotonic(int... A) {
        int len = A.length;
        if(len < 2) {
            return true;
        }

        // 1. 去除重复的数组前缀
        int i = 1;
        while (i < len && A[i] == A[i-1]) { i++; }
        if(i >= len) {
            return true;
        }

        // 2. 判断单调性
        boolean add = A[i] > A[i-1];
        for(;i < len; i++) {
            if(add && A[i] < A[i-1]) {
                return false; // 违反单调递增
            } else if (!add && A[i] > A[i-1]) {
                return false; // 违反单调递减
            }
        }
        return true;
    }
}
