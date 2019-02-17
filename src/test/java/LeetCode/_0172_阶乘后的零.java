package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 题目描述:
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 解题思路
 * https://ahaochan.github.io/posts/trailing_zeros.html
 */
public class _0172_阶乘后的零 {

    @Test
    public void test() {
        Assert.assertEquals(0, trailingZeroes(3));
        Assert.assertEquals(1, trailingZeroes(5));
        Assert.assertEquals(7, trailingZeroes(30));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
