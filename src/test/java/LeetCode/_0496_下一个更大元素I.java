package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 题目描述:
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 * 解题思路
 * 暴力破最快
 */
public class _0496_下一个更大元素I {
    @Test
    public void test1() {
        int[] expect = {-1, 3, -1};
        int[] arg1 = {4, 1, 2}, arg2 = {1, 3, 4, 2};
        Assert.assertArrayEquals(expect, nextGreaterElement(arg1, arg2));
    }

    @Test
    public void test2() {
        int[] expect = {3,-1};
        int[] arg1 = {2,4}, arg2 = {1,2,3,4};
        Assert.assertArrayEquals(expect, nextGreaterElement(arg1, arg2));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21750975/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了93.45%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了54.21%的用户
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len2; i++) {
            for (int j = i + 1; j < len2; j++) {
                if(nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        for (int i = 0, len1 = nums1.length; i < len1; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}
