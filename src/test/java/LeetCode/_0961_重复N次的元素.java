package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 * 题目描述:
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 *
 * 解题思路
 * 2N 个元素, 有个元素 A 重复了 N 次, 那么说明有 3 种情况
 * 1. A 间隔 1 个元素, 如: {A, 2, A, 3, A, 4}
 * 2. 部分 A 相邻, 如: {2, 3, A, A, 4, A}
 * 3. A 间隔超过 1 个元素, 如: {A, 2, 3, A}
 */
public class _0961_重复N次的元素 {
    @Test
    public void test1() {
        Assert.assertEquals(3, repeatedNTimes(1, 2, 3, 3));
        Assert.assertEquals(2, repeatedNTimes(2, 1, 2, 5, 3, 2));
        Assert.assertEquals(5, repeatedNTimes(5, 1, 5, 2, 5, 3, 5, 4));
        Assert.assertEquals(3, repeatedNTimes(8, 3, 2, 3));
        Assert.assertEquals(8, repeatedNTimes(8, 3, 8, 1, 3, 2));
        Assert.assertEquals(9, repeatedNTimes(9, 5, 6, 9));
        Assert.assertEquals(9, repeatedNTimes(9, 5, 6, 9, 3, 9));
        Assert.assertEquals(1, repeatedNTimes(1, 1, 2, 3, 4, 1));
    }

    public int repeatedNTimes(int... A) {
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] == A[i + 1] || A[i] == A[i + 2]) {
                return A[i];
            }
        }
        return A[A.length - 1]; // 解决 {1,2,3,1}
    }
}
