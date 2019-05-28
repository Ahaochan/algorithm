package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * 题目描述:
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 *      小镇的法官不相信任何人。
 *      每个人（除了小镇法官外）都信任小镇的法官。
 *      只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 * 解题思路
 * 统计票数, 找到被投了N-1(除了自己)张票, 并且自己没有投票的人
 */
public class _0997_找到小镇的法官 {
    @Test
    public void test1() {
        Assert.assertEquals(2,  findJudge(2, new int[][]{{1, 2}}));
        Assert.assertEquals(3,  findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        Assert.assertEquals(-1, findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        Assert.assertEquals(-1, findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        Assert.assertEquals(3,  findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19601769/
     * 执行用时 : 5 ms, 在Find the Town Judge的Java提交中击败了98.64% 的用户
     * 内存消耗 : 82.3 MB, 在Find the Town Judge的Java提交中击败了13.67% 的用户
     */
    public int findJudge(int N, int[][] trust) {
        int[] to   = new int[N + 1]; // 第 i 个人收到的票数
        int[] from = new int[N + 1]; // 第 i 个人投出的票数
        for (int i = 0, len = trust.length; i < len; i++) {
            to[trust[i][1]]++;
            from[trust[i][0]]++;
        }
        for (int i = 1, len = to.length; i < len; i++) {
            if(from[i] == 0 && to[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
