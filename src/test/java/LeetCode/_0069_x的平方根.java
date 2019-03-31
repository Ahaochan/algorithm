package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * 题目描述:
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 解题思路
 * 自己的思路, 做二分查找, 找到除数和商的差的绝对值小于1的数, 两者的最小值就是平方根.
 *
 * 看了网上有用牛顿迭代法, 这是高数的内容, 没想到在这里可以用上.
 * 假设 5 的平方根是 2.23..., 那么我们可以假设 x^2 = 5, 这个 x = 2.23...
 * 也就是 f(x) = x^2 – 5 = 0, 那么就是求这个二次函数的零点.
 *
 * 牛顿迭代法, 就是不停的求导, 对曲线做切线, 然后求切线的零点对应的曲线的值, 再做切线, 无限逼近最终解.
 *
 * 有函数 f(x) = 0, 求 x, 任意取一点(a, 0) 作为基准点, 求 f'(a).
 * 那么 f'(a) 的切线, 必过 (a, f(a)) 点, 有斜率有点, 可以推出切线的零点公式, 0 - f(a) = (b - a) * f'(a)
 * 然后得到一个新的基准点 (b, 0), 不停迭代.
 */
public class _0069_x的平方根 {
    @Test
    public void test1() {
        Assert.assertEquals(0, mySqrt1(0));
        Assert.assertEquals(1, mySqrt1(1));
        Assert.assertEquals(1, mySqrt1(2));
        Assert.assertEquals(2, mySqrt1(4));
        Assert.assertEquals(2, mySqrt1(8));
        Assert.assertEquals(10, mySqrt1(101));
        Assert.assertEquals(90, mySqrt1(8192));
        Assert.assertEquals(46339, mySqrt1(2147395599));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, mySqrt(0));
        Assert.assertEquals(1, mySqrt(1));
        Assert.assertEquals(1, mySqrt(2));
        Assert.assertEquals(2, mySqrt(4));
        Assert.assertEquals(2, mySqrt(8));
        Assert.assertEquals(10, mySqrt(101));
        Assert.assertEquals(90, mySqrt(8192));
        Assert.assertEquals(46339, mySqrt(2147395599));
    }

    public int mySqrt1(int x) {
        // 1. 小于 4 不适合做二分查找
        if(x <= 0) return x;
        else if(x < 4) return 1;

        // 2. 二分查找
        int result = 0;
        for(int start = 0, end = x;;) {
            int mid = (start + end) / 2;
            int quotient = x/mid;

            if(quotient - mid < -1) {
                end = mid;
            } else if(quotient - mid > 1) {
                start = mid;
            } else {
                result = Math.min(quotient, mid);
                break;
            }
        }
        return result;
    }

    public int mySqrt(int x) {
        if(x == 0) return 0;
        else if(x < 4) return 1;

        // f(n)  = n^2 – x
        // f'(n) = 2*n
        double point = x >> 1;
        while (Math.abs(point - x * 1.0 / point) > 1e-5) {
            // 0 - f(a)                  = (b - a)     * f'(a)
            //   - f(point)              = (b - point) * f'(point)
            //   - (point * point - x)   = (b - point) * 2 * point
            //   - (point - x/point) / 2 =  b - point
            // b = - (point - x/point) / 2 + point
            point = - (point * point - x) / (2 * point)  + point;
        }
        return (int) point;
    }
}
