package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/majority-element/submissions/
 * 题目描述:
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 解题思路
 * 解法一: 将数组排序, 那么众数必定出现在数组中间, 比如 [1,2,2,2,3,3,4]
 * 解法二: 守擂法, 遇到相同的数字则次数+1, 不同则次数-1, 为0则换一个数字继续守擂.
 */
public class _0169_求众数 {

    @Test
    public void test() {
        Assert.assertEquals(3, majorityElement(3,2,3));
        Assert.assertEquals(2, majorityElement(2,2,1,1,1,2,2));
    }

    public int majorityElement1(int... nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement(int... nums) {

        int master = nums[0], count = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if(master == nums[i]) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                master = nums[i];
                count = 1;
            }
        }
        return master;
    }
}
