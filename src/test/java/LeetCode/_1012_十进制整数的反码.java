package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/complement-of-base-10-integer/
 * 题目描述:
 * 每个非负整数 N 都有其二进制表示。
 * 例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，
 * 依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。
 * 例如，二进制数 "101" 的二进制反码为 "010"。
 * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
 *
 * 解题思路
 * 比如 5 的二进制是 101, 那么 5 的反码是 010 , 也就是2
 * 111 - 101 = 010
 * 所以我们找到比 5 的最高位的 1 大的 1000, 减一得到 111
 * 再减去 101, 即可得到 010
 */
public class _1012_十进制整数的反码 {
    @Test
    public void test1() {
        Assert.assertEquals(2, bitwiseComplement(5));
        Assert.assertEquals(0, bitwiseComplement(7));
        Assert.assertEquals(5, bitwiseComplement(10));
    }

    /**
     * 执行用时 : 1 ms, 在Complement of Base 10 Integer的Java提交中击败了100.00% 的用户
     * 内存消耗 : 31.8 MB, 在Complement of Base 10 Integer的Java提交中击败了100.00% 的用户
     */
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        // 1. 找到比 N 大的 2 的幂次方
        int n = 1;
        while (n <= N) {
            n <<= 1;
        }
        // 2. 用 111...11 减去 N
        return (n - 1 - N);
    }
}
