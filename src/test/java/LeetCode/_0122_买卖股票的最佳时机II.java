package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 题目描述:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 解题思路
 * 贪心算法, 比如价格区间 0 1 3 2
 * 肉眼可见, 最大的利润就是 0 买 3 卖
 * 0买3卖 = 0买1卖 + 1买3卖
 * 在价格曲线中, 只要有递增的情况, 就马上卖出买进.
 * 不必考虑之后更高的价钱.
 */
public class _0122_买卖股票的最佳时机II {

    @Test
    public void test() {
        Assert.assertEquals(7, maxProfit(7,1,5,3,6,4));
        Assert.assertEquals(4, maxProfit(1,2,3,4,5));
        Assert.assertEquals(0, maxProfit(7,6,4,3,1));
        Assert.assertEquals(2, maxProfit(2,4,1));
    }

    public int maxProfit(int... prices) {
        int maxPrice = 0;
        for(int i = 1, len = prices.length; i < len; i++) {
            if(prices[i] > prices[i-1]) {
                maxPrice += prices[i] - prices[i-1];
            }
        }
        return maxPrice;
    }
}
