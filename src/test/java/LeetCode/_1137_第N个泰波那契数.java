package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * 题目描述:
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 解题思路
 * 和斐波那契一样
 */
public class _1137_第N个泰波那契数 {
    @Test
    public void test1() {
        Assert.assertEquals(4, tribonacci(4));
        Assert.assertEquals(1389537, tribonacci(25));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25082560/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了62.55%的用户
     * 内存消耗 :33.4 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;

        int a0 = 0, a1 = 1, a2 = 1;
        for (int i = 3; i <= n; i++) {
            int a3 = a0 + a1 + a2;
            a0 = a1;
            a1 = a2;
            a2 = a3;
        }
        return a2;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25082139/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了62.55%的用户
     * 内存消耗 :34.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int tribonacci_arr(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;

        int[] tri = new int[n+1];
        tri[0] = 0;
        tri[1] = tri[2] = 1;

        for (int i = 3; i <= n; i++) {
            tri[i] = tri[i-3] + tri[i-2] + tri[i-1];
        }
        return tri[n];
    }
}
