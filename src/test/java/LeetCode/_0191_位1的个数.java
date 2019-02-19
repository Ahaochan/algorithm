package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/comments/
 * 题目描述:
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 解题思路
 *
 */
public class _0191_位1的个数 {

    @Test
    public void test1() {
        int origin = Integer.parseUnsignedInt("00000000000000000000000000001011", 2);
        Assert.assertEquals(3, hammingWeight(origin));
    }

    @Test
    public void test2() {
        int origin = Integer.parseUnsignedInt("00000000000000000000000010000000", 2);
        Assert.assertEquals(1, hammingWeight(origin));
    }

    @Test
    public void test3() {
        int origin = Integer.parseUnsignedInt("11111111111111111111111111111101", 2);
        Assert.assertEquals(31, hammingWeight(origin));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= n-1; // 不断把最后一个1去掉
        }
        return count;
    }
}
