package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * 题目描述:
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 * 解题思路
 * 位运算即可
 */
public class _1018_可被5整除的二进制前缀 {

    @Test
    public void test1() {
        Assert.assertEquals(Arrays.asList(true, false, false), prefixesDivBy5(0, 1, 1));
        Assert.assertEquals(Arrays.asList(false, false, false), prefixesDivBy5(1, 1, 1));
        Assert.assertEquals(Arrays.asList(true,false,false,false,true,false), prefixesDivBy5(0,1,1,1,1,1));
        Assert.assertEquals(Arrays.asList(false,false,false,false,false), prefixesDivBy5(1,1,1,0,1));
        Assert.assertEquals(Arrays.asList(false, false, true, false, false, false, false, false, false, false, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, true, false, false, true, true, true, true, true, true, true, false, false, true, false, false, false, false, true, true), prefixesDivBy5(1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0));
    }

    /**
     * 执行用时 : 9 ms, 在Binary Prefix Divisible By 5的Java提交中击败了100.00% 的用户
     * 内存消耗 : 50.4 MB, 在Binary Prefix Divisible By 5的Java提交中击败了100.00% 的用户
     */
    public List<Boolean> prefixesDivBy5(int... A) {
        int len = A.length;
        List<Boolean> result = new ArrayList<>(len);
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum = ((sum << 1) + A[i]) % 5;
            result.add(sum % 5 == 0);
        }
        return result;
    }
}
