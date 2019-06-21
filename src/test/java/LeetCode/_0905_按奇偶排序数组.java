package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 * 题目描述:
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 解题思路
 * 双指针遍历
 */
public class _0905_按奇偶排序数组 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{4,2,1,3}, sortArrayByParity(3, 1, 2, 4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21094554/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了47.16%的用户
     * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了80.75%的用户
     */
    public int[] sortArrayByParity(int... A) {
        int len = A.length, l = 0, r = len - 1;
        while (l < r) {
            while (l < r && A[l] % 2 == 0) l++;
            while (l < r && A[r] % 2 == 1) r--;

            if(l < r) {
                A[l] ^= A[r];
                A[r] ^= A[l];
                A[l] ^= A[r];
            }
        }
        return A;
    }
}
