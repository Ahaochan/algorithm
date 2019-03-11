package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 题目描述:
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 解题思路
 * 标记法, 暴力hash
 */
public class _0349_两个数组的交集 {
    @Test
    public void test1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] expect = {2};
        Assert.assertArrayEquals(expect, intersection(nums1, nums2));
    }

    @Test
    public void test2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] expect = {9,4};
        Assert.assertArrayEquals(expect, intersection(nums1, nums2));
    }

    /**
     * 执行用时 : 6 ms, 在Intersection of Two Arrays的Java提交中击败了76.64% 的用户
     * 内存消耗 : 35.9 MB, 在Intersection of Two Arrays的Java提交中击败了0.82% 的用户
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1= nums1.length, len2 = nums2.length;

        // 1. 标记 nums1 中出现过的数字
        Map<Integer, Boolean> map = new HashMap<>(Math.max(len1, len2));
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], Boolean.TRUE);
        }

        // 2. 求并集
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            int num = nums2[i];
            Boolean flag = map.get(num);
            if(flag != null && flag) {
                list.add(num);
                map.put(num, false);
            }
        }

        // 3. 转为 array
        int[] result = new int[list.size()];
        for (int i = 0, len = list.size(); i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
