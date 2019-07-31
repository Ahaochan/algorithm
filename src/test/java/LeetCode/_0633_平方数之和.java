package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 题目描述:
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 解题思路
 * 使用双指针比单指针快一点
 */
public class _0633_平方数之和 {
    @Test
    public void test1() {
        Assert.assertTrue(judgeSquareSum(5));
        Assert.assertFalse(judgeSquareSum(3));
        Assert.assertTrue(judgeSquareSum(0));
    }

    /**
     * https://leetcode-cn.com/problems/sum-of-square-numbers/submissions/
     * 执行用时 :5 ms, 在所有 Java 提交中击败了88.58%的用户
     * 内存消耗 :32.8 MB, 在所有 Java 提交中击败了83.44%的用户
     */
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        int i = 0;
        while (i <= sqrt) {
            int sum = i * i + sqrt * sqrt;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                sqrt--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20950922/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了40.46%的用户
     * 内存消耗 :32.9 MB, 在所有 Java 提交中击败了82.50%的用户
     */
    public boolean judgeSquareSum_for(int c) {
        if(c <= 0) {
            return true;
        }

        int sqrt = (int) Math.sqrt(c);
        for (int i = 1; i <= sqrt; i++) {
            int num = c - i * i;
            int j = (int) Math.sqrt(num);
            if(j * j == num) {
                return true;
            }
        }
        return false;
    }
}
