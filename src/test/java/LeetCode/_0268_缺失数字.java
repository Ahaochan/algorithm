package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/missing-number/
 * 题目描述:
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 解题思路
 * 求和再减去数组中的所有数, 最后就剩下 missingNumber
 *
 * 或者异或的方法, 位运算比较快
 */
public class _0268_缺失数字 {

    @Test
    public void test1() {
        Assert.assertEquals(2, missingNumber1(3,0,1));
        Assert.assertEquals(8, missingNumber1(9,6,4,2,3,5,7,0,1));
    }

    public int missingNumber(int... nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public int missingNumber1(int... nums) {
        int sum = nums.length;
        for (int i = 0, len = nums.length; i < len; i++){
            sum ^= nums[i];
            sum ^= i;
        }
        return sum;
    }
}
