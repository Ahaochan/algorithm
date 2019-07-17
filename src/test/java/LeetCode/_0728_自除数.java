package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * 题目描述:
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 解题思路
 * 暴力破解
 */
public class _0728_自除数 {
    @Test
    public void test1() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22), selfDividingNumbers(1, 22));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20950185/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了83.81%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了77.17%的用户
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(isDivSelf(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isDivSelf(int num) {
        if(num < 10) {
            return true;
        }
        int n = num;
        boolean is = true;
        while (n > 0) {
            int i = n % 10;
            if(i == 0 || num % i != 0) {
                is = false;
                break;
            }
            n /= 10;
        }
        return is;
    }
}
