package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 题目描述:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 解题思路
 * 位运算
 */
public class _0231_2的幂 {

    @Test
    public void test() {
        Assert.assertTrue(isPowerOfTwo(1));
        Assert.assertTrue(isPowerOfTwo(16));
        Assert.assertFalse(isPowerOfTwo(218));
        Assert.assertFalse(isPowerOfTwo(0));
    }

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while ((n & 1) != 1) {
            n >>= 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
