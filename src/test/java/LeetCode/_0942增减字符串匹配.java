package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/di-string-match/
 * 题目描述:
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 * 解题思路
 * 贪心算法
 */
public class _0942增减字符串匹配 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{0, 4, 1, 3, 2}, diStringMatch("IDID"));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, diStringMatch("III"));
        Assert.assertArrayEquals(new int[]{3, 2, 0, 1}, diStringMatch("DDI"));

    }

    /**
     * 执行用时 : 4 ms, 在DI String Match的Java提交中击败了95.93% 的用户
     * 内存消耗 : 44.4 MB, 在DI String Match的Java提交中击败了78.51% 的用户
     */
    public int[] diStringMatch(String S) {
        int high = S.length(), low = 0;

        int[] result = new int[high + 1];

        for (int i = 0, len = S.length(); i < len; i++) {
            char ch = S.charAt(i);
            if (ch == 'D') {
                result[i] = high--;
            } else if (ch == 'I') {
                result[i] = low++;
            }
        }
        result[result.length-1] = high;
        return result;
    }
}
