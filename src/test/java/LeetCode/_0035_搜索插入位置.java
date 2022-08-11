package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目: https://leetcode-cn.com/problems/search-insert-position/
 * 题解: https://labuladong.github.io/algo/1/11/
 */
public class _0035_搜索插入位置 {
    @Test
    public void test() {
        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
        Assert.assertEquals(0, searchInsert(new int[]{5}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        return this.searchInsertV4(nums, target);
    }

    public int searchInsertV2(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // 从[l, r]中查找
        while (l <= r) { // l == r + 1 跳出, 不必要算l < r, 否则return那里还要再计算一轮if else
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            // [mid + 1, r]或者[l, mid - 1]
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            }
        }
        return l;
    }

    public int searchInsertV4(int[] nums, int target) {
        int l = 0, r = nums.length; // 从[l, r)中查找
        while (l < r) { // l == r 跳出
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
                // [mid + 1, r)或者[l, mid)
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid;
            }
        }
        return l;
    }
}
