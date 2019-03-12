package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 题目描述:
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 解题思路
 * 大数加法. 模拟加法即可.
 *
 */
public class _0989_数组形式的整数加法 {
    @Test
    public void test1() {
        int[] expect = {1,2,3,4};
        List<Integer> actual = addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.get(i).intValue());
        }
    }

    @Test
    public void test2() {
        int[] expect = {4,5,5};
        List<Integer> actual = addToArrayForm(new int[]{2,7,4}, 181);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.get(i).intValue());
        }
    }

    @Test
    public void test3() {
        int[] expect = {1,0,2,1};
        List<Integer> actual = addToArrayForm(new int[]{2,1,5}, 806);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.get(i).intValue());
        }
    }

    @Test
    public void test4() {
        int[] expect = {1,0,0,0,0,0,0,0,0,0,0};
        List<Integer> actual = addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.get(i).intValue());
        }
    }

    /**
     * 执行用时 : 25 ms, 在Add to Array-Form of Integer的Java提交中击败了65.22% 的用户
     * 内存消耗 : 52.2 MB, 在Add to Array-Form of Integer的Java提交中击败了100.00% 的用户
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        int up = 0;
        for(int i = A.length - 1; i >= 0 || K > 0; i--, K /= 10) {
            int num = (i >= 0 ? A[i] : 0) + K % 10 + up;
            up = num / 10;
            num %= 10;
            result.addFirst(num);
        }
        if(up > 0) {
            result.addFirst(up);
        }

        return result;
    }
}
