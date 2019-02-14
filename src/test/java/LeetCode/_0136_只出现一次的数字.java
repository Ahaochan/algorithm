package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 题目描述:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 解题思路
 * 异或运算, a ^ a = 0, 0 ^ b = b
 * 所以只要出现了2次, 就会异或为0, 将所有数异或一次, 最终结果就是只出现一次的数字
 */
public class _0136_只出现一次的数字 {

    @Test
    public void test() {
        Assert.assertEquals(1, singleNumber(2,2,1));
        Assert.assertEquals(4, singleNumber(4,1,2,1,2));
    }

    public int singleNumber(int... nums) {
        int num = nums[0];
        for(int i = 1, len = nums.length; i < len; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
