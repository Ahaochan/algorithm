package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/power-of-three/comments/
 * 题目描述:
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 解题思路
 * 1. for循环暴力除
 * 2. int型的 3的幂的最大值为 3^19=1162261467, 那么 3^19 % n == 0 可以用来判断 n 是否为3的幂
 *
 * 结果暴力反而快一点。。。
 */
public class _0326_3的幂 {
    @Test
    public void test1() {
        Assert.assertTrue(isPowerOfThree(1));
        Assert.assertTrue(isPowerOfThree(27));
        Assert.assertFalse(isPowerOfThree(0));
        Assert.assertTrue(isPowerOfThree(9));
        Assert.assertFalse(isPowerOfThree(45));
    }


    /**
     * 执行用时 : 83 ms, 在Power of Three的Java提交中击败了64.62% 的用户
     * 内存消耗 : 35.6 MB, 在Power of Three的Java提交中击败了1.63% 的用户
     */
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 执行用时 : 86 ms, 在Power of Three的Java提交中击败了29.35% 的用户
     * 内存消耗 : 38.6 MB, 在Power of Three的Java提交中击败了1.22% 的用户
     */
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
