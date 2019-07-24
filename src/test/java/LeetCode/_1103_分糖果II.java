package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * 题目描述:
 * 排排坐，分糖果。
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 * 解题思路
 * 数学题, 找出规律即可
 */
public class _1103_分糖果II {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 1}, distributeCandies(7, 4));
        Assert.assertArrayEquals(new int[]{5, 2, 3}, distributeCandies(10,3));
        Assert.assertArrayEquals(new int[]{12, 14, 9}, distributeCandies(35,3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23772844/
     * https://leetcode-cn.com/submissions/detail/23771170/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了88.66%的用户
     * 内存消耗 :35 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int[] distributeCandies(int candies, int num_people) {
        // 设有 n 人, 最多轮询m次, 共分发 k 次
        // a1=1                         b1=2                        c1=n
        // a2=1+n*(2-1)                 b2=2+n*(2-1)                c2=n+n*(2-1)
        // a3=1+n*(3-1)                 b2=2+n*(3-1)                c2=n+n*(3-1)
        // am=1+n*(m-1)                 bn=2+n*(m-1)                cn=n+n*(m-1)
        // a1+...am=m+n*(1+...m-1)      b1+...bm=2m+n*(1+...m-1)    c1+...cm=nm+n*(1+...m-1)
        // a1+...am=m+n*m*(m-1)/2       b1+...bm=2m+n*m*(m-1)/2     c1+...cm=nm+n*m*(m-1)/2

        // 设有 3 人, 最多轮询 3 次
        // a1=1                         b1=2                        c1=3
        // a2=1+3=4                     b2=2+3=5                    c2=3+3=6
        // a3=1+6=7                     b3=2+6=8                    c3=3+6=9
        // a1+...am=12                  b1+...bm=15                 c1+...cm=18

        // 1. 计算分发了 k 次, 最后分发到第 last 个小朋友, 共轮询了 m 次
        int k = 0;
        for (; (1+k)*k/2 < candies; k++) {}
        int last = (k-1) % num_people, m = (k-1) / num_people + 1;

        int[] result = new int[num_people];
        // 2. 计算 [0, last-1] 的小朋友分到的糖果总数, 第一次用数学公式算, 后面的直接+m
        int i = 0;
        if(i < last) {
            result[i] = (i+1) * m + num_people*m*(m-1)/2;
            candies -= result[i];
            i++;
        }
        for (; i < last; i++) {
            result[i] = result[i-1] + m;
            candies -= result[i];
        }

        // 3. 计算 [last+1, num_people) 的小朋友分到的糖果总数, 第一次用数学公式算, 后面的直接+m
        m--; // 计算上一轮的分发数量
        i = last+1;
        if(i < num_people) {
            result[i] = (i+1) * m + num_people*m*(m-1)/2;
            candies -= result[i];
            i++;
        }
        for (; i < num_people; i++) {
            result[i] = result[i-1] + m;
            candies -= result[i];
        }

        // 4. 最后剩下的分给最后一个小朋友
        result[last] = candies;
        return result;
    }
}
