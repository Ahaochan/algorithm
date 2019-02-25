package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/comments/
 * 题目描述:
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 解题思路
 * 暴力破解
 */
public class _0219_存在重复元素II {

    @Test
    public void test() {
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Assert.assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
