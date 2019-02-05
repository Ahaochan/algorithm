package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * 题目描述:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 解题思路
 * 用栈的思想, 弹出原数末位作为新数的首位.
 * 注意溢出的情况
 */
public class _0007_整数反转 {
    public static void main(String[] args) {
        _0007_整数反转 main = new _0007_整数反转();
        System.out.println(main.reverse(123));  //  321
        System.out.println(main.reverse(-123)); // -321
        System.out.println(main.reverse(120));  //   21
        System.out.println(main.reverse(1534236469)); // 1056389759
    }

    @Test
    public void test() {
        Assert.assertEquals(321, reverse(123));  //  321
        Assert.assertEquals(-321, reverse(-123)); // -321
        Assert.assertEquals(21, reverse(120));  //   21
        Assert.assertEquals(0, reverse(1534236469)); // 1056389759
    }

    public int reverse(int x) {
        // 1. 处理负数
        boolean negative = x < 0;
        if (negative) x = -x;

        // 2. 翻转
        long result = 0;
        while (x > 0) {
            // 2.1. 原数末位弹出, 作为新数的首位
            int pop = x % 10;
            result = result * 10 + pop;

            // 2.2. 计算下一位
            x /= 10;

            // 2.3. 溢出则返回0
            if(result > Integer.MAX_VALUE) return 0;
        }

        // 3. 处理负数
        if (negative) result = -result;
        return (int) result;
    }
}
