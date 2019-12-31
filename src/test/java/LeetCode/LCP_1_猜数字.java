package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/guess-numbers/
 * 题目描述:
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * 解题思路
 * 语法题
 */
public class LCP_1_猜数字 {
    @Test
    public void test() {
        Assert.assertEquals(3, game(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        Assert.assertEquals(1, game(new int[]{2, 2, 3}, new int[]{3, 2, 1}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/41808339/
     * 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 : 34 MB , 在所有 java 提交中击败了 100.00% 的用户
     */
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0, len = guess.length; i < len; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
