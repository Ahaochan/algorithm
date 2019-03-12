package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/arranging-coins/
 * 题目描述:
 * 对你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 *
 * 解题思路
 * 数学题
 * 第1行: 1
 * 第2行: 3
 * 第3行: 6
 * 第n行: (n^2+n)/2 = x
 * n^2 + n - 2x = 0;
 * n = (-1 + √(1-4*(-2x)))/2
 * n = (-1 + √(1+8*x))/2
 */
public class _0441_排列硬币 {
    @Test
    public void test1() {
        Assert.assertEquals(1, arrangeCoins(1));
        Assert.assertEquals(2, arrangeCoins(3));
        Assert.assertEquals(2, arrangeCoins(5));
        Assert.assertEquals(3, arrangeCoins(6));
        Assert.assertEquals(3, arrangeCoins(8));
        Assert.assertEquals(65535, arrangeCoins(2147483647));
    }

    /**
     * 执行用时 : 61 ms, 在Arranging Coins的Java提交中击败了39.34% 的用户
     * 内存消耗 : 46.6 MB, 在Arranging Coins的Java提交中击败了0.74% 的用户
     */
    public int arrangeCoins_add(int n) {
        // 模拟加法
        int i = 0;
        long sum = 0;
        for (int num = 0; sum <= n; num++, sum += num, i++) ;
        return i - 1;
    }

    /**
     * 执行用时 : 32 ms, 在Arranging Coins的Java提交中击败了87.15% 的用户
     * 内存消耗 : 37.8 MB, 在Arranging Coins的Java提交中击败了27.61% 的用户
     */
    public int arrangeCoins(int n) {
        // 一元二次方程公式算法
        return (int) ((Math.sqrt(1 + (long) 8 * n) - 1) / 2);
    }
}
