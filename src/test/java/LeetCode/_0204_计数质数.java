package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/count-primes/
 * 题目描述:
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 解题思路
 * 筛法求质数
 */
public class _0204_计数质数 {

    @Test
    public void test1() {
        Assert.assertEquals(4, countPrimes(10));
        Assert.assertEquals(0, countPrimes(2));
    }

    public int countPrimes(int n) {
        boolean[] noPrimes = new boolean[n];

        int count = 0; // 1 不是质数
        for(int i = 2, len = noPrimes.length; i < len; i++) {
            if(noPrimes[i]) {
                continue;
            }

            count++;
            for(int j = i + i; j < len; j += i) {
                noPrimes[j] = true;
            }
        }

        return count;
    }
}
