package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 * 题目描述:
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * <p>
 * 解题思路
 * 数学题, 求对数
 * 或者直接穷举
 */
public class _1295_统计位数为偶数的数字 {
    @Test
    public void test1() {
        Assert.assertEquals(2, findNumbers(12, 345, 2, 6, 7896));
        Assert.assertEquals(1, findNumbers(555, 901, 482, 1771));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/41989844/
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :38.7 MB, 在所有 java 提交中击败了100.00%的用户
     */
    public int findNumbers(int... nums) {
        int count = 0;
        for (int num : nums) {
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                ++count;
            }
        }
        return count;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/41990018/
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :38.6 MB, 在所有 java 提交中击败了100.00%的用户
     */
    public int findNumbers_force(int... nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 100000 || (num >= 1000 && num < 10000) || (num >= 10 && num < 100)) {
                count++;
            }
        }
        return count;
    }
}
