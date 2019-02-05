package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * 题目描述:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 解题思路
 * 模拟加法运算
 */
public class _0053_加一 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(9));
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(1,2,3));
        Assert.assertArrayEquals(new int[]{4,3,2,2}, plusOne(4,3,2,1));
        Assert.assertArrayEquals(new int[]{2,4,9,4,0}, plusOne(2,4,9,3,9));
    }

    public int[] plusOne(int... digits) {
        // 1. 加一
        digits[digits.length-1]++;
        // 2. 进位
        boolean overflow = false;
        for(int i = digits.length - 1, plus = 0; i >= 0; i--){
            if(plus == 1) {
                digits[i]++;
                plus = 0;
            }
            if(digits[i] > 9) {
                if(i == 0) overflow = true;
                plus = 1;
                digits[i] %= 10;
            }
        }
        // 3. 溢出的情况, 申请新数组
        if(overflow) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
        }
        return digits;

    }
}
