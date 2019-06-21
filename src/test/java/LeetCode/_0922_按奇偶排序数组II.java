package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * 题目描述:
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 解题思路
 * 双指针遍历
 */
public class _0922_按奇偶排序数组II {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{4,5,2,7}, sortArrayByParityII(4,2,5,7));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21095171/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了59.95%的用户
     * 内存消耗 :50.9 MB, 在所有 Java 提交中击败了37.86%的用户
     */
    public int[] sortArrayByParityII(int... A) {
        int len = A.length, odd = 1, even = 0;

        while (odd < len && even < len) {
            while (odd < len && A[odd] % 2 == 1) odd += 2;
            while (even < len && A[even] % 2 == 0) even += 2;

            if(odd < len && even < len) {
                A[odd] ^= A[even];
                A[even] ^= A[odd];
                A[odd] ^= A[even];
            }
        }
        return A;
    }
}
