package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 题目描述:
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 解题思路
 * 语文题
 * 找到原数组的最大值和最小值, 比如 {min, 0, 1, 2, 3, max}
 * 根据题意, 每个元素都会加上一个值 x
 * 要使 (max - |x1|) - (min + |x2|) 最小.
 * 那么结果应该是 max(0, (max-k) - (min + k))
 */
public class _0908_最小差值I {
    @Test
    public void test1() {
        Assert.assertEquals(0, smallestRangeI(new int[]{1}, 0));
        Assert.assertEquals(6, smallestRangeI(new int[]{0, 10}, 2));
        Assert.assertEquals(0, smallestRangeI(new int[]{1, 3, 6}, 3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25915216/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了94.42%的用户
     * 内存消耗 :44.8 MB, 在所有 Java 提交中击败了67.81%的用户
     */
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : A) {
            if(num > max) max = num;
            if(num < min) min = num;
        }
//        return Math.max(0, (max - K) - (min + K));
        return Math.max(0, max - K - min - K);
    }
}
