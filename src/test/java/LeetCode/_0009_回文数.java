package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 题目描述:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 解题思路
 * 用栈的思想, 反转一半的数字和原数的另一半数字进行对比.
 * 关键在于怎么判断 反转数字的位数已经达到原始数字位数的一半?
 *
 */
public class _0009_回文数 {
    @Test
    public void test() {
        Assert.assertTrue(isPalindrome(121));   // true
        Assert.assertFalse(isPalindrome(-121)); // false, 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        Assert.assertFalse(isPalindrome(10));   // false, 从右向左读, 为 01 。因此它不是一个回文数。
    }

    public boolean isPalindrome(int x) {
        // 1. 负数都不是回文数
        if(x < 0) return false;
        // 2. 个位为0的数, 除了0, 都不是回文数
        if(x != 0 && x % 10 == 0) return false;

        // 3. 获取一半的数字, 反转
        int reversal = 0;
        while(x > reversal) {
            reversal = reversal * 10 + x % 10;
            x /= 10;
        }

        // 4. 判断一半的数字反转后是否于原数相等, 如果是奇数, 则 reversal/10 去除中间的数
        return x == reversal || x == reversal/10;
    }
}
