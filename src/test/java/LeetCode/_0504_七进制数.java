package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/base-7/
 * 题目描述:
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 解题思路
 * 简单的进制转换
 */
public class _0504_七进制数 {
    @Test
    public void test1() {
        Assert.assertEquals("202", convertToBase7(100));
        Assert.assertEquals("-10", convertToBase7(-7));
    }

    /**
     * 执行用时 : 18 ms, 在Base 7的Java提交中击败了40.08% 的用户
     * 内存消耗 : 40.1 MB, 在Base 7的Java提交中击败了0.00% 的用户
     */
    public String convertToBase7(int num) {
        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();
        int radix = 7;
        while (num >= radix) {
            sb.append(num % radix);
            num /= radix;
        }
        sb.append(num);
        if(negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
