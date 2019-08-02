package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/third-maximum-number/
 * 题目描述:
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 解题思路
 * for循环暴力破, 如果前n个的话就要用大顶堆做
 */
public class _0414_第三大的数 {
    @Test
    public void test1() {
        Assert.assertEquals(1, thirdMax(3, 2, 1));
        Assert.assertEquals(2, thirdMax(1, 2));
        Assert.assertEquals(1, thirdMax(2, 2, 3, 1));
        Assert.assertEquals(2, thirdMax(1, 2, 2, 5, 3, 5));
        Assert.assertEquals(-2147483648, thirdMax(1, 2, -2147483648));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24643267/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.64%的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了89.78%的用户
     */
    public int thirdMax(int... nums) {
        long max1 = Long.MIN_VALUE, max2 = max1, max3 = max1;

        for (int num : nums) {
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num < max2){
                max3 = num;
            }
        }

        return (int) (max3 > Long.MIN_VALUE ? max3 : max1);
    }
}
