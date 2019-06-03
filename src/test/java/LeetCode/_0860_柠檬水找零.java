package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * 题目描述:
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 解题思路
 * 语法题
 */
public class _0860_柠檬水找零 {
    @Test
    public void test1() {
        Assert.assertTrue(lemonadeChange(5, 5, 5, 10, 20));
        Assert.assertTrue(lemonadeChange(5, 5, 10));
        Assert.assertFalse(lemonadeChange(10, 10));
        Assert.assertFalse(lemonadeChange(5, 5, 10, 10, 20));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19952319/
     * 执行用时 : 4 ms, 在Lemonade Change的Java提交中击败了81.88% 的用户
     * 内存消耗 : 45.4 MB, 在Lemonade Change的Java提交中击败了77.41% 的用户
     */
    public boolean lemonadeChange(int... bills) {
        int money5 = 0, money10 = 0;
        for (int i = 0, len = bills.length; i < len; i++) {
            if(bills[i] == 5) {
                money5++;
            } else if(bills[i] == 10) {
                money10++;
                money5--;
            } else if(bills[i] == 20) {
//                money20++;
                if(money10 > 0) {
                    money10--;
                    money5--;
                } else {
                    money5 -= 3;
                }
            }
            if(money5 < 0) {
                return false;
            }
        }
        return true;
    }
}
