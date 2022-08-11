package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目: https://leetcode-cn.com/problems/binary-search/
 * 题解: https://labuladong.github.io/algo/1/11/
 */
public class _0704_二分查找 {

    @Test
    public void test() {
        Assert.assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Assert.assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        Assert.assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
        Assert.assertEquals(5, search(new int[]{-1, 0, 3, 5, 9, 12}, 12));
        Assert.assertEquals(0, search(new int[]{5}, 5));
    }

    public int search(int[] nums, int target) {
        return searchV4(nums, target);
    }

    public int searchV2(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // [l, r]中查找
        while (l <= r) { // l == r + 1 跳出, 也就是[r+1, r]区间
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            // 因为nums[mid]已经判断过了, 所以要去[left, mid-1] 或 [mid + 1, right]
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int searchV3(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // [l, r]中查找
        while (l < r) { // l == r 跳出, 也就是[r, r]区间, 要打补丁判断nums[l] == target
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            // 因为nums[mid]已经判断过了, 所以要去[left, mid-1] 或 [mid + 1, right]
            } else if (nums[mid] < target) {
                // 因为nums[mid]已经判断过了, 所以+1
                l = mid + 1;
            } else if (nums[mid] > target) {
                // 因为nums[mid]已经判断过了, 所以-1
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public int searchV4(int[] nums, int target) {
        int l = 0, r = nums.length; // [l, r)中查找
        while (l < r) { // l == r 跳出, 也就是[r, r)区间. 如果写l <= r是没有意义的, [r+1, r)没意义
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            // 因为nums[mid]已经判断过了, 所以要去[left, mid) 或 [mid + 1, right)
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            }
        }
        return -1;
    }
}
