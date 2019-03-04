package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 * 题目描述:
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 解题思路
 * 暴力破解
 */
public class _0263_丑数 {

    @Test
    public void test1() {
        Assert.assertTrue(isUgly(1));
        Assert.assertTrue(isUgly(6));
        Assert.assertTrue(isUgly(8));
        Assert.assertFalse(isUgly(14));
    }

    public boolean isUgly(int num) {
        if(num < 1) return false;

        while (num % 2 == 0) {
            num >>= 1;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1 || num == 2 || num == 3 || num == 5;
    }
}
