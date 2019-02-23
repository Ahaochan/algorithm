package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * 题目描述:
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 解题思路
 * 数学题, https://zh.wikipedia.org/zh/%E5%BF%AB%E6%A8%82%E6%95%B8
 */
public class _0202_快乐数 {

    @Test
    public void test1() {
        // 1^2 + 9^2 = 82
        // 8^2 + 2^2 = 68
        // 6^2 + 8^2 = 100
        // 1^2 + 0^2 + 0^2 = 1
        Assert.assertTrue(isHappy(19));
    }

    public boolean isHappy(int n) {
        // 不使用 Set 判断不快乐数, 因为不快乐数是一个循环, 总会出现 4, 并且使用 Set 判断的耗时 超过 多计算几次直到判断 n==4 的耗时
//        Set<Integer> unhappy = new HashSet<>(8);
//        unhappy.add(4);
//        unhappy.add(16);
//        unhappy.add(37);
//        unhappy.add(58);
//        unhappy.add(89);
//        unhappy.add(145);
//        unhappy.add(42);
//        unhappy.add(20);
//        unhappy.add(4);

        // 1. 缓存 [0..9]^2 结果集
        int[] power = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

        // 2. 当 n 为1 或者 n 进入 不快乐循环, 则 while 结束
        while (n != 1 && n!= 4) {

            // 3. 计算每个位置上的平方和
            int num = 0;
            while(n > 0) {
                num += power[n%10];
                n /= 10;
            }
            n = num;
        }
        // 3. 判断是否为快乐数
        return n == 1;
    }
}
