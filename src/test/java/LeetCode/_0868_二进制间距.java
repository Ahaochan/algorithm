package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-gap/
 * 题目描述:
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * 如果没有两个连续的 1，返回 0 。
 *
 * 解题思路
 * 刚开始用字符串做, 太慢。
 * 改位运算就快了
 *
 */
public class _0868_二进制间距 {
    @Test
    public void test1() {
        // 22 的二进制是 0b10110 。
        // 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
        // 第一对连续的 1 中，两个 1 之间的距离为 2 。
        // 第二对连续的 1 中，两个 1 之间的距离为 1 。
        // 答案取两个距离之中最大的，也就是 2 。
        Assert.assertEquals(2, binaryGap(22));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, binaryGap(5));
        Assert.assertEquals(1, binaryGap(6));
        Assert.assertEquals(0, binaryGap(8));
    }

    /**
     * 字符串操作
     * 执行用时 : 20 ms, 在Binary Gap的Java提交中击败了27.30% 的用户
     * 内存消耗 : 39.6 MB, 在Binary Gap的Java提交中击败了0.00% 的用户
     */
    public int binaryGap_str(int N) {
        String binary = Integer.toBinaryString(N);
        int len = binary.length();

        // 1. 找到第一个1
        int firstOne = -1;
        for (int i = 0; i < len && firstOne < 0; i++) {
            if(binary.charAt(i) == '1') {
                firstOne = i;
            }
        }
        if(firstOne < 0) {
            return 0;
        }

        // 2. 遍历字符串找出最大间隔
        int gap = 0;
        for(int i = firstOne + 1; i < len; i++) {
            char ch = binary.charAt(i);
            if(ch == '1') {
                gap = Math.max(gap, i - firstOne);
                firstOne = i;
            }
        }
        return gap;
    }

    /**
     * 位运算操作, {@link #binaryGap_str(int)} 的位运算版本
     * 执行用时 : 19 ms, 在Binary Gap的Java提交中击败了45.56% 的用户
     * 内存消耗 : 39.3 MB, 在Binary Gap的Java提交中击败了0.00% 的用户
     */
    public int binaryGap(int N) {
        if(N <= 0) {
            return 0;
        }

        // 1. 找到第一个1
        while ((N & 1) != 1) {
            N >>= 1;
        }
        if(N == 1) {
            return 0;
        }

        // 2. 遍历字符串找出最大间隔
        int gap = 0, maxGap = 0;
        while (N > 0) {
            gap++;
            if((N & 1) == 1) {
                maxGap = Math.max(maxGap, gap);
                gap = 0;
            }
            N >>= 1;

        }
        return maxGap;
    }
}
