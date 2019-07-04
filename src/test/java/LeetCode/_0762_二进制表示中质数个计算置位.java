package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * 题目描述:
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * 解题思路
 * 写半天, 还没直接调用API来的快, 是我太菜
 */
public class _0762_二进制表示中质数个计算置位 {
    @Test
    public void test1() {
        Assert.assertEquals(4, countPrimeSetBits(6, 10));
        Assert.assertEquals(5, countPrimeSetBits(10, 15));
        Assert.assertEquals(23, countPrimeSetBits(842, 888));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22009055/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.3 MB, 在所有 Java 提交中击败了72.06%的用户
     */
    public int countPrimeSetBits(int L, int R) {
        // 1. 数据范围 10^6 最多有 20bit, 也就是最多 20 个 1, 直接缓存质数数组
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0};
        int count = 0;
        for (; L <= R; L++) {
            // 2. 计算数有多少个1
            int one = Integer.bitCount(L);

            // 3. 二分查找是否是质数
            count += primes[one];
        }

        return count;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22008952/
     * 执行用时 :8 ms, 在所有 Java 提交中击败了93.11%的用户
     * 内存消耗 :33.9 MB, 在所有 Java 提交中击败了72.06%的用户
     */
    public int countPrimeSetBits_api(int L, int R) {
        // 1. 数据范围 10^6 最多有 20bit, 也就是最多 20 个 1, 直接缓存质数数组
        boolean[] primes = {false, false, true, true, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, false, false, false, false, true, false, true, false};

        int count = 0;
        for (; L <= R; L++) {
            // 2. 计算数有多少个1
            int one = Integer.bitCount(L);

            // 3. 二分查找是否是质数
            count += primes[one] ? 1 : 0;
        }

        return count;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22008465/
     * 执行用时 :12 ms, 在所有 Java 提交中击败了87.05%的用户
     * 内存消耗 :33.3 MB, 在所有 Java 提交中击败了72.06%的用户
     */
    public int countPrimeSetBits_slow(int L, int R) {
        // 1. 数据范围 10^6 最多有 20bit, 也就是最多 20 个 1, 直接缓存质数数组
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};

        int count = 0;
        for (; L <= R; L++) {
            // 2. 计算数有多少个1
            int num = L, one = 0;
            while (num > 0) {
                one++;
                num &= num - 1;
            }

            // 3. 二分查找是否是质数
            int idx = Arrays.binarySearch(primes, one);
            if (idx >= 0) {
                count++;
            }
        }

        return count;
    }
}
