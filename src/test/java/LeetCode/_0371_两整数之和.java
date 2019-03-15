package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * 题目描述:
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 *
 * 解题思路
 * https://ahao.moe/posts/a_b_problem.html
 *
 */
public class _0371_两整数之和 {
    @Test
    public void test1() {
        Assert.assertEquals(3, getSum(1, 2));
        Assert.assertEquals(1, getSum(-2, 3));
    }


    public int getSum(int a, int b) {
        do {
            int xor=a^b, and=(a&b)<<1;
            a = xor;
            b = and;
        } while(b != 0);
        return a;
    }
}
