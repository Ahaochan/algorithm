package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 * 题目描述:
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 解题思路
 * 两次暴力for, 都耗时比较长
 * {@link #findMaxConsecutiveOnes_skip(int...)}
 * {@link #findMaxConsecutiveOnes_order(int...)}
 * 时间复杂度必定是O(N)
 * 那么就只能从一次循环的计算次数下手
 *
 * 用双指针, 计算一段1的左右端点, 用一次减法代替多次加法
 *
 */
public class _0485_最大连续1的个数 {
    @Test
    public void test1() {
        Assert.assertEquals(0, findMaxConsecutiveOnes(0));
        Assert.assertEquals(1, findMaxConsecutiveOnes(1));
        Assert.assertEquals(1, findMaxConsecutiveOnes(1, 0));
        Assert.assertEquals(3, findMaxConsecutiveOnes(1, 1, 0, 1, 1, 1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21557606/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了97.21%的用户
     * 内存消耗 :51 MB, 在所有 Java 提交中击败了37.53%的用户
     */
    public int findMaxConsecutiveOnes(int... nums) {
        int len = nums.length;
        int max = 0;

        int left = 0;
        while (left < len) {
            if(nums[left] == 1) {
                int right = left + 1;
                while (right < len && nums[right] != 0) right++;
                max = Math.max(max, right - left);
                left = right;
            }
            left++;
        }

        return max;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21552785/
     * 执行用时 :7 ms, 在所有 Java 提交中击败了34.85%的用户
     * 内存消耗 :51.2 MB, 在所有 Java 提交中击败了35.23%的用户
     */
    public int findMaxConsecutiveOnes_order(int... nums) {
        int max = 0, tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
                max = Math.max(max, tmp);
            } else {
                tmp = 0;
            }
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21552314/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了15.04%的用户
     * 内存消耗 :51.6 MB, 在所有 Java 提交中击败了32.02%的用户
     */
    public int findMaxConsecutiveOnes_skip(int... nums) {
        int idx = 0, len = nums.length;
        while (idx < len && nums[idx] == 0) idx++;
        if(idx == len) {
            return 0; // dirty case
        }
        if(idx == len - 1) {
            return nums[len - 1]; // dirty case
        }

        int max = 1;
        while (idx < len) {
            if(nums[idx] == 1) {
                nums[idx] = idx > 0 ? nums[idx - 1] + 1 : nums[idx]; // dirty case
                max = Math.max(max, nums[idx]);
            }
            idx++;
        }
        return max;
    }
}
