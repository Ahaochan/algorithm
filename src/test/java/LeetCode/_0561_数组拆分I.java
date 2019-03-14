package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 * 题目描述:
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 解题思路
 * 直接排序, 然后获取下标为奇数的元素和即可.
 *
 */
public class _0561_数组拆分I {
    @Test
    public void test1() {
        Assert.assertEquals(1, arrayPairSum(1, 1));
        Assert.assertEquals(4, arrayPairSum(1,4,3,2));
    }

    /**
     * 执行用时 : 42 ms, 在Array Partition I的Java提交中击败了46.07% 的用户
     * 内存消耗 : 51.9 MB, 在Array Partition I的Java提交中击败了1.25% 的用户
     * @param nums
     * @return
     */
    public int arrayPairSum(int... nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length - 2; i >= 0; i-=2) {
            sum += nums[i];
        }
        return sum;
    }
}
