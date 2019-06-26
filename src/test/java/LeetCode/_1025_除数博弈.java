package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/divisor-game/
 * 题目描述:
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 * 解题思路
 * N 的 x 取值有两种情况
 * 1. 当 N 为奇数时, x 必定为奇数
 * 1. 当 N 为偶数时, x 可能为奇数或偶数
 *
 * 游戏规则是, 当轮到谁取值, 此时 N 为 1 时, 则输, 换句话说, 当上一个人取值时, N 为 2, 则上一个人赢.
 * 也就是说, 谁取值时, N 为 2, 只需要取 x = 1, 则获胜.
 *
 * 当初始 N 为偶数时, 爱丽丝为了保持自己永远拥有偶数的 N, 只要取奇数的 x 即可, 最简单的就是取 x = 1.
 * 这样下一轮, 鲍勃对于奇数 N, 取到的 x 必定为奇数, 奇数 - 奇数 = 偶数, 那么爱丽丝永远拥有偶数的 N, 直到 N = 2.
 *
 * 当初始 N 为奇数时, 爱丽丝取完 x, 奇数 - 奇数 = 偶数, N 必定为偶数.
 * 那么鲍勃只要永远取 x = 1, 则鲍勃自己永远拥有偶数的 N, 直到 N = 2.
 *
 * 也就是说, 因为爱丽丝是先手, 只要初始 N 为偶数, 那么爱丽丝只要一直取 x = 1, 就稳赢.
 */
public class _1025_除数博弈 {
    @Test
    public void test1() {
        Assert.assertTrue(divisorGame(2));
        Assert.assertFalse(divisorGame(3));
        Assert.assertTrue(divisorGame(4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21408085/
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :32.9 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
