package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 题目描述:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 解题思路
 * 假定一个 sum 数组, sum[i] 表示 num[0]...num[i] 的和
 * 那么, num[i]...num[j] = sum[j] - sum[i - 1]
 */
public class _0303_区域和检索数组不可变 {
    @Test
    public void test1() {
        NumArray main = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, main.sumRange(0, 2));
        Assert.assertEquals(-1, main.sumRange(2, 5));
        Assert.assertEquals(-3, main.sumRange(0, 5));
    }


    private class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length];
            for (int i = 0, len = nums.length; i < len; i++) {
                sum[i] = (i == 0 ? nums[i] : sum[i - 1] + nums[i]);
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sum[j] : sum[j] - sum[i - 1];
        }
    }
}
