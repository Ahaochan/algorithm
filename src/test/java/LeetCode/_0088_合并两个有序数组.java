package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 题目描述:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 解题思路
 * 从后往前遍历
 */
public class _0088_合并两个有序数组 {

    @Test
    public void test() {
        int[] num1 = {1,2,3,0,0,0}, num2 = {2,5,6};
        merge(num1, 3, num2, 3);

        int[] expect = {1,2,2,3,5,6};
        Assert.assertArrayEquals(expect, num1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. 获取数组的下标, 方便计算
        int i = (m--) + (n--) - 1;
//        int i = m + n - 1;
//        m--;
//        n--;

        // 2. 从后往前遍历, 填充到 num1 后面
        while ( m >= 0 && n >= 0) {
            nums1[i--] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
//            if(nums1[m] < nums2[n]) {
//                nums1[i] = nums2[n];
//                n--;
//            } else {
//                nums1[i] = nums1[m];
//                m--;
//            }
//            i--;
        }

        // 3. 剩下的再填充到 num1
        while(n >= 0) {
            nums1[i--] = nums2[n--];
        }
    }
}
