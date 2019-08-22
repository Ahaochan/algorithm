package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 题目描述:
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 解题思路
 */
public class _0238_除自身以外数组的乘积 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(1, 2, 3, 4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26848078/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了89.01%的用户
     * 内存消耗 :54.9 MB, 在所有 Java 提交中击败了5.06%的用户
     */
    public int[] productExceptSelf(int... nums) {
        int len = nums.length;
        int[] result = new int[len];

        // 1. 记录 nums[i] 左边的乘积
        int left = 1;
        for (int i = 0; i < len; i++) {
            result[i] = left;
            left *= nums[i];
        }

        // 2. 乘以 nums[i] 右边的乘积
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26847049/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了28.97%的用户
     * 内存消耗 :51.3 MB, 在所有 Java 提交中击败了22.91%的用户
     */
    public int[] productExceptSelf_slow(int... nums) {
        int len = nums.length;
        // 1. 记录 nums[i] 左边的乘积
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        // 2. 记录 nums[i] 右边的乘积
        int[] right = new int[len];
        right[len-1] = 1;
        for (int i = len-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        // 3. 左右乘积相乘
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
