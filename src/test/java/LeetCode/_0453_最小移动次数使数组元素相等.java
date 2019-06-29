package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * 题目描述:
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 *
 * 解题思路
 * 设所有元素相等时为 k, x 为最小移动次数, 则有 x = k - min(nums)
 *
 * 数组元素总和增加量              = 终止时数组元素总和 - 开始时数组元素总和
 * x * (n-1)                     = k * len(nums) - sum(nums)
 * (k-min(nums)) * (n-1)         = k * n - sum(nums)
 * k * (n-1) - min(nums) * (n-1) = k * n - sum(nums)
 * sum(nums) - min(nums) * (n-1) = k * n - k * (n-1)
 * sum(nums) - min(nums) * (n-1) = k
 * sum(nums) - min(nums) * n     = k - min(nums)
 * sum(nums) - min(nums) * n     = x
 */
public class _0453_最小移动次数使数组元素相等 {
    @Test
    public void test1() {
        Assert.assertEquals(3, minMoves(1, 2, 3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21617955/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了99.23%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了92.13%的用户
     */
    public int minMoves(int... nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num) ;
        }
        return sum - min * nums.length;
    }
}
