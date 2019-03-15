package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * 题目描述:
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 *
 * 解题思路
 * 二分查找
 *
 */
public class _0374_猜数字大小 {
    @Test
    public void test1() {
        Assert.assertEquals(6, guessNumber(10));
    }

    /**
     * 执行用时 : 1 ms, 在Guess Number Higher or Lower的Java提交中击败了87.10% 的用户
     * 内存消耗 : 32.6 MB, 在Guess Number Higher or Lower的Java提交中击败了0.73% 的用户
     */
    public int guessNumber(int n) {
        int l = 1, r = n;
        int mid = 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int guess = guess(mid);
            switch (guess) {
                case 0: return mid;
                case 1: l = mid + 1; break;
                case -1: r = mid - 1; break;
            }
        }
        return mid;
    }

    public int guess(int n) {
        int num = 6;
        if(n > num) {
            return -1;
        } else if (n < num) {
            return 1;
        }
        return 0;
    }
}
