package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * 题目描述:
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 解题思路
 */
public class _0697_数组的度 {
    @Test
    public void test1() {
        Assert.assertEquals(2, findShortestSubArray(1, 2, 2, 3, 1));
        Assert.assertEquals(6, findShortestSubArray(1, 2, 2, 3, 1, 4, 2));
    }

    public int findShortestSubArray(int... nums) {
        int num = nums[0], count = 1, len = nums.length;
        for (int i = 1; i < len; i++) {
            if(num == nums[i]) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                num = nums[i];
                count++;
            }
        }

        count = 0;
        for (int i = 0; i < len; i++) {
            if(num == nums[i]) {
                count++;
            }
        }
        return count;
    }
}
