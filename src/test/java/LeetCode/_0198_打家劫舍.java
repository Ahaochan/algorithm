package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 题目描述:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 解题思路
 * 动态规划, 转移方程是: dp[i] = max(num[i-1], num[i-2]+num[i])
 */
public class _0198_打家劫舍 {

    @Test
    public void test1() {
        // 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        // 偷窃到的最高金额 = 1 + 3 = 4 。
        Assert.assertEquals(4, rob(1,2,3,1));
    }

    @Test
    public void test2() {
        // 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        // 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
        Assert.assertEquals(12, rob(2,7,9,3,1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, rob(2,1,1,2));
    }

    public int rob(int... nums) {
        // 1. 排除特殊情况, switch 比 if 慢
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // 2. 避免 test3 的情况
        nums[1] = Math.max(nums[0], nums[1]);

        // 3. 动态规划, dp[i] = max(num[i-1], num[i-2]+num[i])
        for(int i = 2, len = nums.length; i < len; i++) {
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
        }
        return nums[nums.length - 1];
    }
}
