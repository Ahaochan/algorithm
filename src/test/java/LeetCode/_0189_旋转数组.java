package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * 题目描述:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 解题思路
 * 三步翻转法
 * 记 X 字符串的翻转为 X^T, 那么 ((X^T)(Y^T))^T = YX
 * 注意, 先翻转整体, 再翻转局部
 */
public class _0189_旋转数组 {

    @Test
    public void test1() {
        int[] actual = {1, 2, 3, 4, 5, 6, 7};
        rotate(actual, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, actual);
    }

    @Test
    public void test2() {
        int[] actual = {-1, -100, 3, 99};
        rotate(actual, 2);
        Assert.assertArrayEquals(new int[]{3, 99, -1, -100}, actual);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        // 1. 先翻转整体
        for(int start = 0, end = n - 1; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }

        // 2. 再翻转前面
        for(int start = 0, end = k - 1; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }

        // 3. 再翻转后面
        for(int start = k, end = n - 1; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}
