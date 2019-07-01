package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/perfect-number/
 * 题目描述:
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 * 解题思路
 * 语法题
 * 要刷时间, 可以直接算出所有的结果直接返回, 完美数还是挺少的
 */
public class _0507_完美数 {
    @Test
    public void test1() {
        Assert.assertFalse(checkPerfectNumber(1));
        Assert.assertTrue(checkPerfectNumber(28));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21748301/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了77.54%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了76.85%的用户
     */
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2, len = (int) Math.sqrt(num); i <= len; i++) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return num > 1 && sum == num;
    }


    public boolean checkPerfectNumber_cache(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
