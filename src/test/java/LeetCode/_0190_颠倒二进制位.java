package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-bits/comments/
 * 题目描述:
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 解题思路
 * 位运算, 类似三步翻转法
 */
public class _0190_颠倒二进制位 {

    @Test
    public void test1() {
        int origin = Integer.parseUnsignedInt("00000010100101000001111010011100", 2);
        int expect = Integer.parseUnsignedInt("00111001011110000010100101000000", 2);
        Assert.assertEquals(expect, reverseBits(origin));
    }

    @Test
    public void test2() {
        int origin = Integer.parseUnsignedInt("11111111111111111111111111111101", 2);
        int expect = Integer.parseUnsignedInt("10111111111111111111111111111111", 2);
        Assert.assertEquals(expect, reverseBits(origin));
    }

    public int reverseBits(int n) {
        n = (n << 16) | (n >>> 16);
        n = ((n & 0x00ff00ff) << 8) | ((n & 0xff00ff00) >>> 8);
        n = ((n & 0x0f0f0f0f) << 4) | ((n & 0xf0f0f0f0) >>> 4);
        n = ((n & 0x33333333) << 2) | ((n & 0xcccccccc) >>> 2);
        n = ((n & 0x55555555) << 1) | ((n & 0xaaaaaaaa) >>> 1);
        return n;
    }
}
