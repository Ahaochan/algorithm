package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目: https://leetcode-cn.com/problems/first-bad-version/
 * 题解: https://labuladong.github.io/algo/1/11/
 */
public class _0278_第一个错误的版本 {

    @Test
    public void test1() {
        Assert.assertEquals(4, firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        return this.firstBadVersionV2(n);
    }

    public int firstBadVersionV2(int n) {
        int l = 0, r = n; // [l, r)中查找
        while (l < r) { // l == r 跳出, 也就是[r, r)区间. 如果写l <= r是没有意义的, [r+1, r)没意义
            int mid = l + (r - l) / 2;
            if(isBadVersion(mid)) {
                // mid是坏版本, 就从[l, mid)查找
                r = mid;
            } else {
                // mid不是坏版本, 就继续从[mid+1, r)中查找
                l = mid + 1;
            }
        }
        return r;
    }


    protected boolean isBadVersion(int version) {
        return version >= 4;
    }
}
