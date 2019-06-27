package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 题目描述:
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 解题思路
 */
public class _0674_最长连续递增序列 {
    @Test
    public void test1() {
        Assert.assertEquals(0, findLengthOfLCIS());
        Assert.assertEquals(3, findLengthOfLCIS(1, 3, 5, 4, 7));
        Assert.assertEquals(1, findLengthOfLCIS(2, 2, 2, 2, 2));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21476477/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了96.94%的用户
     * 内存消耗 :42.4 MB, 在所有 Java 提交中击败了41.66%的用户
     */
    public int findLengthOfLCIS(int... nums) {
        int len = nums.length;
        if(len <= 0) {
            return 0;
        }

        int max = 1, tmp = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i] > nums[i - 1]) {
                tmp++;
                max = Math.max(max, tmp);
            } else {
                tmp = 1;
            }
        }
        return max;
    }
}
