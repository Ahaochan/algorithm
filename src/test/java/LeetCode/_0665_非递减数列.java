package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * 题目描述:
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 解题思路
 * 看注释
 */
public class _0665_非递减数列 {


    @Test
    public void test1() {
        Assert.assertTrue(checkPossibility(4, 2, 3));
        Assert.assertFalse(checkPossibility(4, 2, 1));
        Assert.assertFalse(checkPossibility(3, 4, 2, 3));
        Assert.assertTrue(checkPossibility(-1, 4, 2, 3));
        Assert.assertTrue(checkPossibility(1));
        Assert.assertTrue(checkPossibility(2, 3, 3, 2, 4));
        Assert.assertTrue(checkPossibility(1, 2, 4, 5, 3));
        Assert.assertFalse(checkPossibility(3, 3, 2, 2));
    }

    /**
     * 执行用时 : 4 ms, 在Non-decreasing Array的Java提交中击败了69.57% 的用户
     * 内存消耗 : 49 MB, 在Non-decreasing Array的Java提交中击败了48.19% 的用户
     */
    public boolean checkPossibility(int... nums) {
        int len = nums.length;
        if (len < 3) {
            return true;
        }


        int count = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            count++;
        }

        for (int i = 1; i < len - 1; i++) {
            // 1. 以3个数为一组进行判断
            int left = nums[i - 1], mid = nums[i], right = nums[i + 1];
            // 2. 如果 array[i] > array[i + 1], 则必须发生一次改变
            //    1 1 1             2 1 1               3 1 1
            //    1 1 2             2 1 2               3 1 2
            //    1 1 3             2 1 3               3 1 3
            //    1 2 1             2 2 1               3 2 1
            //    1 2 2             2 2 2               3 2 2
            //    1 2 3             2 2 3               3 2 3
            //    1 3 1             2 3 1               3 3 1
            //    1 3 2             2 3 2               3 3 2
            //    1 3 3             2 3 3               3 3 3
            // 过滤掉不需要调换的组合
            //    1 2(1) 1          2(1) 1 1            3(1) 1 1
            //    1 3(1) 1          2(1) 1 2            3(1) 1 2
            //    1 3(1) 2          2(1) 1 3            3(1) 1 3
            //                      2    2 1(3)         3    2(3) 1(3)
            //                      2    3 1(3)         3(1) 2 2
            //                      2    3 2(3)         3(1) 2 3
            //                                          3    3 1(3)
            //                                          3    3 2(3)
            // 保留 array[i] > array[i + 1] 的, array[i-1] > array[i] 本质是一样的
            //    1 2(1) 1          2    2 1(3)         3    2(3) 1(3)
            //    1 3(1) 2          2    3 1(3)         3    3    1(3)
            //                      2    3 2(3)         3    3    2(3)


            // array[i] > array[i+1]
            if (mid > right) {
                count++;

                //  array[i-1] > array[i+1], 则改变最后一个, 例如: 231
                if (left > right) {
                    nums[i + 1] = mid;
                }
                //  array[i-1] <= array[i+1], 则改变第二个, 例如: 132
                else {
                    nums[i] = left;
                }
            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
