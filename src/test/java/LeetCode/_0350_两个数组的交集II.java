package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 题目描述:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 解题思路
 * 1. 标记法, 暴力hash
 * 2. 排序法
 */
public class _0350_两个数组的交集II {
    @Test
    public void test1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] expect = {2,2};
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
     * 执行用时 : 7 ms, 在Intersection of Two Arrays II的Java提交中击败了58.60% 的用户
     * 内存消耗 : 36.3 MB, 在Intersection of Two Arrays II的Java提交中击败了1.00% 的用户
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1= nums1.length, len2 = nums2.length;

        // 1. 标记 nums1 中出现过的数字
        Map<Integer, Integer> map = new LinkedHashMap<>(Math.max(len1, len2));
        for (int i = 0; i < len1; i++) {
            int num = nums1[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 求并集
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            int num = nums2[i];
            Integer count = map.get(num);
            if(count != null && count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }

        // 3. 转为 array
        int[] result = new int[list.size()];
        for (int i = 0, len = list.size(); i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 执行用时 : 6 ms, 在Intersection of Two Arrays II的Java提交中击败了67.20% 的用户
     * 内存消耗 : 36.5 MB, 在Intersection of Two Arrays II的Java提交中击败了1.00% 的用户
     */
    public int[] intersection_sort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length, len2 = nums2.length;
        List<Integer> list = new ArrayList<>(Math.max(len1, len2));
        for(int i = 0, j = 0; i < len1 && j < len2;) {
            int num1 = nums1[i], num2 = nums2[j];
            if (num1 < num2) {
                i++;
            } else if (num1 > num2) {
                j++;
            } else {
                list.add(num1);
                i++;
                j++;
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
