package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-digits/
 * 题目描述:
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 解题思路
 * 可以循环模拟做, 也有数学公式直接O(1)
 */
public class _0258_各位相加 {

    @Test
    public void test1() {
        Assert.assertEquals(2, addDigits(38));
        Assert.assertEquals(9, addDigits(9));
        Assert.assertEquals(0, addDigits(0));
    }

    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
