package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 题目描述:
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 解题思路
 * 动态规划问题, 记 dp[i] 为爬到第 i 个阶梯花费的最少体力, 那么有
 * dp[0] = cost[0];
 * dp[1] = cost[1];
 * dp[2] = cost[2] + min( dp[0], dp[1])
 * 状态转移方程为 dp[i] = cost[i] + min( dp[i-1], dp[i-2] )
 */
public class _0746_使用最小花费爬楼梯 {
    @Test
    public void test1() {
        Assert.assertEquals(15, minCostClimbingStairs(10, 15, 20));
        Assert.assertEquals(6, minCostClimbingStairs(1, 100, 1, 1, 1, 100, 1, 1, 100, 1));
    }

    /**
     * 执行用时 : 4 ms, 在Min Cost Climbing Stairs的Java提交中击败了55.83% 的用户
     * 内存消耗 : 36.2 MB, 在Min Cost Climbing Stairs的Java提交中击败了92.82% 的用户
     */
    public int minCostClimbingStairs(int... cost) {
        int len = cost.length;
        int[] dp = new int[len];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int min = Math.min(dp[i-1], dp[i-2]);
            dp[i] = cost[i] + min;
        }

        return Math.min(dp[len-1], dp[len-2]);
    }
}
