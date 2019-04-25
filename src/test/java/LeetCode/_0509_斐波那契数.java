package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 题目描述:
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * 给定 N，计算 F(N)。
 *
 * 解题思路
 */
public class _0509_斐波那契数 {


    @Test
    public void test1() {
        Assert.assertEquals(0, fib(0));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(1, fib(2));
        Assert.assertEquals(2, fib(3));
        Assert.assertEquals(3, fib(4));
    }

    /**
     * 执行用时 : 0 ms, 在Fibonacci Number的Java提交中击败了100.00% 的用户
     * 内存消耗 : 32.8 MB, 在Fibonacci Number的Java提交中击败了73.67% 的用户
     */
    public int fib(int N) {
        if(N <= 0) {
            return 0;
        }

        int a = 1, b = 1;
        while (N-- > 2) { // 前两项为1 1
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
