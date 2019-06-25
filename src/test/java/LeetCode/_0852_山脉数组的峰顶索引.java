package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * 题目描述:
 * 我们把符合下列属性的数组 A 称作山脉：
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 * 解题思路
 * 二分查找
 */
public class _0852_山脉数组的峰顶索引 {
    @Test
    public void test1() {
        Assert.assertEquals(1, peakIndexInMountainArray(0, 1, 0));
        Assert.assertEquals(1, peakIndexInMountainArray(0, 2, 1, 0));
        Assert.assertEquals(5, peakIndexInMountainArray(18, 29, 38, 59, 98, 100, 99, 98, 90));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21336053/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了88.80%的用户
     * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了96.33%的用户
     */
    public int peakIndexInMountainArray(int... A) {
        int l = 0, r = A.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if(A[mid-1] < A[mid]) {
                if(A[mid] > A[mid+1]) return mid;
                else l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
