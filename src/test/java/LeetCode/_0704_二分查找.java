package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 题目描述:
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 解题思路
 * 二分查找
 */
public class _0704_二分查找 {

    @Test
    public void test1() {
        Assert.assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Assert.assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12},2));
        Assert.assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
    }

    /**
     * 执行用时 : 5 ms, 在Binary Search的Java提交中击败了34.67% 的用户
     * 内存消耗 : 48.8 MB, 在Binary Search的Java提交中击败了0.77% 的用户
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
