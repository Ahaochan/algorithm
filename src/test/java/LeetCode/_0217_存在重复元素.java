package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 题目描述:
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 解题思路
 * 排序再对比
 */
public class _0217_存在重复元素 {

    @Test
    public void test() {
        Assert.assertTrue(containsDuplicate(1,2,3,1));
        Assert.assertFalse(containsDuplicate(1,2,3,4));
        Assert.assertTrue(containsDuplicate(1,1,1,3,3,4,3,2,4,2));
    }

    public boolean containsDuplicate(int... nums) {
        Arrays.sort(nums);
        for(int i = 1, len = nums.length; i < len; i++) {
            if(nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
