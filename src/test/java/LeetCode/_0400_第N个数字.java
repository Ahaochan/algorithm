package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/nth-digit/
 * 题目描述:
 * 在无限的整数序列 1234567891011, ...中找到第 n 个数字。、
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 *
 *
 * 解题思路
 * 数学规律题
 */
public class _0400_第N个数字 {
    @Test
    public void test() {
        Assert.assertEquals(3, findNthDigit(3));
        Assert.assertEquals(0, findNthDigit(11));
        Assert.assertEquals(6, findNthDigit(123));

        Assert.assertEquals(1, findNthDigit(190));
        Assert.assertEquals(0, findNthDigit(191));
        Assert.assertEquals(0, findNthDigit(192));

        Assert.assertEquals(1, findNthDigit(193));

        Assert.assertEquals(1, findNthDigit(256));
        Assert.assertEquals(2, findNthDigit(257));
        Assert.assertEquals(2, findNthDigit(258));

        Assert.assertEquals(1, findNthDigit(1000000));
        Assert.assertEquals(1, findNthDigit(1000000000));
    }

    /**
     * 执行用时 : 1 ms, 在Nth Digit的Java提交中击败了98.86% 的用户
     * 内存消耗 : 32.8 MB, 在Nth Digit的Java提交中击败了80.00% 的用户
     */
    public int findNthDigit(int n) {
        // 1. 低于 10 直接返回
        if (n < 10) {
            return n;
        }

        // 2. 找出数的最高位, 记f(a,b)为[a,b]范围内数字的总数, 记 k(i)为9*10^i, i为第i行
        // f(1,            9) = 9
        // f(10,          99) = 9*10     *2 = k(0) * 10 * 2
        // f(100,        999) = 9*100    *3 = k(1) * 10 * 3
        // f(1000,      9999) = 9*1000   *4 = k(2) * 10 * 4
        // f(10000,    99999) = 9*10000  *5 = k(3) * 10 * 5
        // f(100000,  999999) = 9*100000 *6 = k(4) * 10 * 6
        // f(1000000,9999999) = 9*1000000*7 = k(5) * 10 * 7
        int high = 1;
        long down = 9;
        while (n - (down * high) > 0) {
            n -= (down * high);
            high++;
            down *= 10;
        }

        // 3. 找出数字是数的第几位
        int index = (n - 1) % high;
        // 4. 还原数
        long num = (down / 9) + ((n - 1) / high);
        return Long.toString(num).charAt(index) - '0';
    }
}
