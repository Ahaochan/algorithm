package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * 题目描述:
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 解题思路
 * 位运算
 */
public class _0693_交替位二进制数 {
    @Test
    public void test1() {
        Assert.assertTrue(hasAlternatingBits(5));
        Assert.assertFalse(hasAlternatingBits(7));
        Assert.assertFalse(hasAlternatingBits(11));
        Assert.assertTrue(hasAlternatingBits(10));
    }

    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
