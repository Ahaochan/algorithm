package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 题解: https://labuladong.github.io/algo/1/11/
 */
public class _0034_在排序数组中查找元素的第一个和最后一个位置 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{3,4}, searchRange(new int[]{5,7,7,8,8,10}, 8));
        Assert.assertArrayEquals(new int[]{-1,-1}, searchRange(new int[]{5,7,7,8,8,10}, 11));
        Assert.assertArrayEquals(new int[]{-1,-1}, searchRange(new int[]{5,7,7,8,8,10}, 6));
        Assert.assertArrayEquals(new int[]{-1,-1}, searchRange(new int[]{}, 0));
        Assert.assertArrayEquals(new int[]{-1,-1}, searchRange(new int[]{1}, 0));
    }

    public int[] searchRange(int[] nums, int target) {
        return searchInsertV3(nums, target);
    }

    public int[] searchInsertV2(int[] nums, int target) {
        if(nums.length <= 0) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];

        int l = 0, r = nums.length; // 从[l, r)中查找
        while (l < r) { // l == r 跳出, 也就是[r, r)
            int mid = l + (r - l) / 2;
            // 如果相等, 就收缩右边界, 因为右开, 所以直接r = mid
            if(nums[mid] == target) {
                r = mid;
            // 如果不等, 就排除掉mid, 收缩边界[mid + 1, r)或者[l, mid)
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid;
            }
        }
        // 如果[l, l), 越界就返回-1, 如果没越界, 就判断nums[l]是否等于target
        if(l == nums.length || nums[l] != target) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = l;

        l = 0; r = nums.length;  // 从[l, r)中查找
        while (l < r) { // l == r 跳出, 也就是[r, r)
            int mid = l + (r - l) / 2;
            // 如果相等, 就收缩左边界, 因为左闭, 要排除掉mid, 所以直接l = mid + 1
            if(nums[mid] == target) {
                l = mid + 1;
            // 如果不等, 就排除掉mid, 收缩边界[mid + 1, r)或者[l, mid)
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid;
            }
        }
        // 因为左闭排除掉了mid, 所以此时nums[l]必然不等于target, 所以要l - 1
        result[1] = l - 1;
        return result;
    }

    public int[] searchInsertV3(int[] nums, int target) {
        if(nums.length <= 0) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];

        int l = 0, r = nums.length - 1; // 从[l, r]中查找
        while (l <= r) { // l == r+1 跳出, 也就是[r+1, r]
            int mid = l + (r - l) / 2;
            // 如果相等, 就收缩右边界, 因为右闭, 所以直接r = mid - 1
            if(nums[mid] == target) {
                r = mid - 1;
            // 如果不等, 就排除掉mid, 收缩边界[mid+1, r]或者[l, mid-1]
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            }
        }
        // 如果[l, r], 越界就返回-1, 如果没越界, 就判断nums[r]是否等于target
        if(l == nums.length || nums[l] != target) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = l;

        l = 0; r = nums.length - 1;  // 从[l, r]中查找
        while (l <= r) { // l == r+1 跳出, 也就是[r+1, r]
            int mid = l + (r - l) / 2;
            // 如果相等, 就收缩左边界, 因为左闭, 要排除掉mid, 所以直接l = mid + 1
            if(nums[mid] == target) {
                l = mid + 1;
            // 如果不等, 就排除掉mid, 收缩边界[mid+1, r]或者[l, mid-1]
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            }
        }
        // 因为左闭排除掉了mid, 所以此时nums[l]必然不等于target, 所以要l - 1, 也就是r
        result[1] = r;
        return result;
    }
}
