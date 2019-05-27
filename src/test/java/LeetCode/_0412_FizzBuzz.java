package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 * 题目描述:
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 解题思路
 * 语法题
 */
public class _0412_FizzBuzz {
    @Test
    public void test1() {
        List<String> expect = Arrays.asList(  "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        List<String> actual = fizzBuzz(15);
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    /**
     * 执行用时 : 3 ms, 在Fizz Buzz的Java提交中击败了92.23% 的用户
     * 内存消耗 : 41.3 MB, 在Fizz Buzz的Java提交中击败了78.89% 的用户
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        int num3 = 3, num5 = 5;
        for(int i = 1; i <= n; i++) {
            if(i == num3 && i == num5) {
                num3 += 3;
                num5 += 5;
                result.add("FizzBuzz");
            } else if(i == num3) {
                num3 += 3;
                result.add("Fizz");
            } else if(i == num5) {
                num5 += 5;
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
