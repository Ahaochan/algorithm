package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 题目描述:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * 解题思路
 * 本来想用动态规划做, 结果差点超时, 时间复杂度是O(n^2)
 * 后来用贪心做, 时间复杂度O(n)
 *
 */
public class _0121_买卖股票的最佳时机 {

    @Test
    public void test() {
        Assert.assertEquals(5, maxProfit(7,1,5,3,6,4));
        Assert.assertEquals(0, maxProfit(7,6,4,3,1));
    }

    public int maxProfit1(int... prices) {
        // 暴力O(n^2)
        int max = 0;
        for(int i = 0, len = prices.length; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                int profit = -prices[i] + prices[j];
                if(profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    public int maxProfit(int... prices) {
        int minPrice = Integer.MAX_VALUE, maxPrice = 0;
        // 贪心 1次循环
        for(int i = 0, len = prices.length; i < len; i++) {

            // 1. 找到迄今为止的历史最低点
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 2. 用当前的价格减去历史最低点
            else if(prices[i] - minPrice > maxPrice) {
                maxPrice = prices[i] - minPrice;
            }
        }
        return maxPrice;
    }
}
