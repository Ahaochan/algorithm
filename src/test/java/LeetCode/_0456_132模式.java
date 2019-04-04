package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/132-pattern/
 * 题目描述:
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
 * 当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 解题思路
 */
public class _0456_132模式 {

    @Test
    public void test1() {
        Assert.assertFalse(find132pattern());
        Assert.assertFalse(find132pattern(1, 2, 3, 4));
        Assert.assertTrue(find132pattern(3, 1, 4, 2));
        Assert.assertTrue(find132pattern(-1, 3, 2, 0));
    }

    /**
     * 执行用时 : 570 ms, 在132 Pattern的Java提交中击败了23.46% 的用户
     * 内存消耗 : 48.8 MB, 在132 Pattern的Java提交中击败了0.00% 的用户
     */
    public boolean find132pattern(int... nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        for (int i = 1, min = nums[0]; i < len; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } else {
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] > min && nums[i] > nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
