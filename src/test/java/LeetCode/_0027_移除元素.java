package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 题目描述:
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 解题思路
 * 用一个数组记录每个数字的偏移量, 然后再一步到位
 * 时间复杂度是O(n)
 *
 */
public class _0027_移除元素 {
    @Test
    public void test1() {
        int[] arr = {3,2,2,3};
        int len = removeElement(arr, 3);
        int[] expect = {2, 2};

        Assert.assertEquals(2, len);
        for(int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], arr[i]);
        }
    }

    @Test
    public void test2() {
        int[] arr = {0,1,2,2,3,0,4,2};
        int len = removeElement(arr, 2);
        int[] expect = {0,1,3,0,4};

        Assert.assertEquals(5, len);
        for(int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], arr[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length <= 0) return 0;

        // 1. 偏移量数组
        int[] offset = new int[nums.length];
        int newLen = 0;

        // 2. 记录每个数字的偏移量
        for (int i = 0; i < nums.length; i++) {
            if(val != nums[i]) {
                offset[i] = i-1 >= 0 ? offset[i-1] : 0;
                newLen++;
            } else {
                offset[i] = (i-1 >= 0 ? offset[i-1] : 0) + 1;
            }
        }

        // 3. 一步到位
        for (int i = 0; i < nums.length; i++) {
            if(val != nums[i]) {
                nums[i-offset[i]] = nums[i];
            }
        }
        return newLen;
    }
}
