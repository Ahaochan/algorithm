package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * 题目描述:
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 解题思路
 * 假设数组中都是正数, [+, +, +, +, +, +]
 * 那么我们只要取最大3个数即可 max1 * max2 * max3
 * 但是, 如果出现了负数, [-, -, +, +, +, +], 只要最大的3个数还是正数, 那么结果依旧是 max1 * max2 * max3
 *
 * 那么极端一点, [-, -, -, -, +, +], 当负数出现在最大的3个数之间, 有3种情况
 * 1. 最大的3个数出现了1次负数 [-, -, -, -, +, +], 那么最大值必定是最小的两个数 乘以最大的一个数, max1 * min1 * min2
 * 2. 最大的3个数出现了2次负数 [-, -, -, -, -, +], 那么最大值必定是 max1 * max(max2 * max3, min1 * min2)
 * 3. 最大的3个数出现了3次负数 [-, -, -, -, -, -], 那么最大值必定是 max1 * max2 * max3
 *
 * 也就是结果为 max1 * max(max2 * max3, min1 * min2)
 * 可以通过排序找出, 或者for循环遍历找出
 */
public class _0628_三个数的最大乘积 {
    @Test
    public void test1() {
        Assert.assertEquals(6, maximumProduct(1, 2, 3));
        Assert.assertEquals(24, maximumProduct(1, 2, 3, 4));
        Assert.assertEquals(720, maximumProduct(-4, -3, -2, -1, 60));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21619902/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了97.36%的用户
     * 内存消耗 :49.4 MB, 在所有 Java 提交中击败了44.42%的用户
     */
    public int maximumProduct(int... nums) {
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
        int min1 = Integer.MAX_VALUE, min2 = min1;

        for (int num : nums) {
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3) {
                max3 = num;
            }

            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num < min2) {
                min2 = num;
            }
        }

        return max1 * Math.max(max2 * max3, min1 * min2);


    }

    /**
     * https://leetcode-cn.com/submissions/detail/21619646/
     * 执行用时 :30 ms, 在所有 Java 提交中击败了67.50%的用户
     * 内存消耗 :49.9 MB, 在所有 Java 提交中击败了34.75%的用户
     */
    public int maximumProduct_for(int... nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - 1] * Math.max(nums[len - 2] * nums[len - 3], nums[1] * nums[0]);
    }
}
