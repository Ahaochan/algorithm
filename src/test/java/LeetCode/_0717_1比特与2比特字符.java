package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * 题目描述:
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 解题思路
 * 两个bit的组合有00, 01, 10, 11
 * 当 bits[i] == 1 时, 那么后一个 bit 必定和当前的 bits[i] 组成一个字符.
 * 当 bits[i] == 0 时, 那么当前的 bit[i] 就是一个字符.
 * for(i ... len) {
 *     i += ( bits[i] == 1) ? 2 : 1
 * }
 * 循环一遍, 最后就可以判断 i == bits.length - 1 && bits[bits.length - 1] == 0.
 * 最后一个 bit 是否构成一个字符.
 *
 * 优化思路:
 * 两个bit的组合有00, 01, 10, 11, 那么有且只有 01 可以确定其为两个字符的交界.
 * 那么我们先从后往前找到 01, 再往后找即可. 当然也可以二分查找, 但是我试了下, 可能数据量少, 优化不是很明显.
 *
 */
public class _0717_1比特与2比特字符 {
    @Test
    public void test1() {
        Assert.assertTrue(isOneBitCharacter(new int[]{1,1,0}));
        Assert.assertTrue(isOneBitCharacter(new int[]{1,0,0}));
        Assert.assertFalse(isOneBitCharacter(new int[]{1,1,1,0}));
    }

    /**
     * 执行用时 : 8 ms, 在1-bit and 2-bit Characters的Java提交中击败了68.31% 的用户
     * 内存消耗 : 37.7 MB, 在1-bit and 2-bit Characters的Java提交中击败了0.00% 的用户
     */
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
//        int i = len - 2;
//        for(; i >= 0 && !(bits[i] == 0 && bits[i+1] == 1); i--);
//        i = Math.max(i, 0);

        int i = 0;
        for(; i < len - 1;) {
            i += (bits[i] == 1) ? 2 : 1;
        }
        return i == len - 1 && bits[len - 1] == 0;
    }
}
