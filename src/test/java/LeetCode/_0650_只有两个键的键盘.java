package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 题目描述:
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *      Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 *      Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 解题思路
 * 记 f(n) 为 数字n 的最少操作次数.
 * 列出前10个, 可以看到 f(质数) = 质数 本身, f(合数) != 合数 本身.
 * 那我们尝试将合数拆成质数, 可以看到
 * f(4)  = f(2) + f(2)
 * f(6)  = f(2) + f(3)
 * f(8)  = f(2) + f(4) = f(2) + f(2) + f(2)
 * f(9)  = f(3) + f(3)
 * f(10) = f(2) + f(5)
 * 本质就是一个质因数分解的过程
 */
public class _0650_只有两个键的键盘 {


    @Test
    public void test1() {
        Assert.assertEquals(2, minSteps(2));  // A A
        Assert.assertEquals(3, minSteps(3));  // A A A
        Assert.assertEquals(4, minSteps(4));  // A A AA
        Assert.assertEquals(5, minSteps(5));  // A A A A A
        Assert.assertEquals(5, minSteps(6));  // A A AA AA
        Assert.assertEquals(7, minSteps(7));  // A A A A A A A
        Assert.assertEquals(6, minSteps(8));  // A A AA AA AA
        Assert.assertEquals(6, minSteps(9));  // A A A AAA AAA
        Assert.assertEquals(7, minSteps(10)); // A A AA AA AA AA
    }

    /**
     * 执行用时 : 1 ms, 在2 Keys Keyboard的Java提交中击败了100.00% 的用户
     * 内存消耗 : 31.7 MB, 在2 Keys Keyboard的Java提交中击败了99.22% 的用户
     */
    public int minSteps(int n) {
        int res = 0;
        for(int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
