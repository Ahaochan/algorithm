package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/power-of-four/comments/
 * 题目描述:
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 解题思路
 * 1. for循环暴力除
 * 2. 位运算解法
 *
 * 2        =        10
 * 4  = 4^1 =       100
 * 16 = 4^2 =    1 0000
 * 64 = 4^3 = 0100 0000
 * 可以看到, 1 都在奇数位
 */
public class _0342_4的幂 {
    @Test
    public void test1() {
        Assert.assertFalse(isPowerOfFour(0));
        Assert.assertTrue(isPowerOfFour(16));
        Assert.assertFalse(isPowerOfFour(5));
    }

    /**
     * 执行用时 : 5 ms, 在Power of Four的Java提交中击败了62.98% 的用户
     * 内存消耗 : 33.4 MB, 在Power of Four的Java提交中击败了0.60% 的用户
     */
    public boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    /**
     * 执行用时 : 5 ms, 在Power of Four的Java提交中击败了62.98% 的用户
     * 内存消耗 : 33 MB, 在Power of Four的Java提交中击败了0.60% 的用户
     */
    public boolean isPowerOfFour1(int num) {
        int rule = 0b0101_0101_0101_0101_0101_0101_0101_0101;
        return num > 0 && ((num & (num-1)) == 0) && ((num & rule) == num);
    }
}
