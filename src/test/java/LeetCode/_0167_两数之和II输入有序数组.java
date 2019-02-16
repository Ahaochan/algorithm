package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 题目描述:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 解题思路
 * 有序数组, 那么就可以用两个指针从前后往中间扫
 * 
 */
public class _0167_两数之和II输入有序数组 {

    @Test
    public void test1() {
        int[] actual = twoSum(new int[]{2,7,11,15}, 9);
        Assert.assertEquals(1, actual[0]);
        Assert.assertEquals(2, actual[1]);
    }

    @Test
    public void test2() {
        int[] actual = twoSum(new int[]{2,3,4}, 6);
        Assert.assertEquals(1, actual[0]);
        Assert.assertEquals(3, actual[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        for(int l = 0, r = numbers.length - 1; l < r;) {
            if(numbers[l] + numbers[r] == target) {
                int[] result = new int[2];
                result[0] = l + 1; result[1] = r + 1;
                return result;
            } else if(numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
