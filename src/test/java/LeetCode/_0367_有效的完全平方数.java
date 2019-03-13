package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 题目描述:
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 解题思路
 * 1. 二分查找
 * 2. 数学推导 1 + 3 + 5 + ... + (2n-1) = n^2
 *
 */
public class _0367_有效的完全平方数 {
    @Test
    public void test1() {
        Assert.assertTrue(isPerfectSquare_math(1));
        Assert.assertFalse(isPerfectSquare_math(5));
        Assert.assertTrue(isPerfectSquare_math(16));
        Assert.assertFalse(isPerfectSquare_math(14));
    }

    /**
     * 执行用时 : 0 ms, 在Valid Perfect Square的Java提交中击败了100.00% 的用户
     * 内存消耗 : 31.9 MB, 在Valid Perfect Square的Java提交中击败了0.68% 的用户
     *
     * 二分查找
     */
    public boolean isPerfectSquare_(int num) {
        if(num == 1) {
            return true;
        }

        int l = 0, r = num;
        while (l <= r) {
            // 1. (l + r) / 2 => l + (r - l) / 2, 防止溢出
            int mid = l + (r - l) / 2;
            // 2. mid * mid = num => mid = num / mid, 防止溢出
            double div = num *1.0 / mid;
            if(mid == div) {
                return true;
            } else if (mid < div) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    /**
     * 执行用时 : 2 ms, 在Valid Perfect Square的Java提交中击败了32.56% 的用户
     * 内存消耗 : 32.2 MB, 在Valid Perfect Square的Java提交中击败了0.68% 的用户
     *
     * 1 + 3 + 5 + ... + (2n-1) = n^2
     */
    public boolean isPerfectSquare_math(int num) {
        for(int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }
}
