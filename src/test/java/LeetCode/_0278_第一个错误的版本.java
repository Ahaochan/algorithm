package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * 题目描述:
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 解题思路
 * 二分查找
 */
public class _0278_第一个错误的版本 {

    @Test
    public void test1() {
        Assert.assertEquals(4, firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int start = 0, end = n;

        int mid = start + (end - start) / 2;
        while (start < end) {

            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return mid;
    }

    protected boolean isBadVersion(int version) {
        return version >= 4;
    }
}
