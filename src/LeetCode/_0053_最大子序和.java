package LeetCode;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 题目描述:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 解题思路
 * 动态规划, 每加上后一个元素, 如果当前和比当前元素小, 则和更新为当前元素.
 * 比如-2,1,-3,4,-1,2,1,-5,4
 * num = -2时, sum = -2
 * num = 1时, sum = -1, -1比1小, 则sum更新为1
 * num = -3时, sum = -2, -2比-3大, 则不更新sum
 * num = 4时, sum = 2, 2比4小, 则sum更新为4
 * 依次类推
 *
 */
public class _0053_最大子序和 {
    public static void main(String[] args) {
        _0053_最大子序和 main = new _0053_最大子序和();
        System.out.println(main.maxSubArray(-2,1,-3,4,-1,2,1,-5,4)); // 6
        System.out.println(main.maxSubArray(-1)); // -1
    }

    public int maxSubArray(int... nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < nums[i]) {
                sum = nums[i];
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
