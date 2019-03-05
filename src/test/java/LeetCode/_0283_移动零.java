package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 题目描述:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 解题思路
 * 直接暴力for循环
 */
public class _0283_移动零 {

    @Test
    public void test1() {
        int[] actual = {0,1,0,3,12};
        int[] expect = {1,3,12,0,0};
        moveZeroes(actual);
        Assert.assertArrayEquals(expect, actual);
    }

    public void moveZeroes(int[] nums) {
        int j = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < len) {
            nums[j++] = 0;
        }

    }
}
