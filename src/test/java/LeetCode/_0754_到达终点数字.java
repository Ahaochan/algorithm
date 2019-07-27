package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reach-a-number/
 * 题目描述:
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * 返回到达终点需要的最小移动次数。
 *
 * 解题思路
 * 数学题
 */
public class _0754_到达终点数字 {
    @Test
    public void test1() {
        Assert.assertEquals(2, reachNumber(3));
        Assert.assertEquals(3, reachNumber(2));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24070483/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了63.75%的用户
     */
    public int reachNumber(int target) {
        // 1. 因为正反有对称性, 所以直接取绝对值
        target = Math.abs(target);

        // 2. n*(n+1)/2 >= target
        //    n*(n+1)   >= target*2
        int n = (int) Math.sqrt(target * 2);
        int dt = n*(n+1)/2 - target;
        while (dt < 0) {
            n++;
            dt += n;
        }

        if (dt % 2 == 0) {
            // 3. 设 a 为正向移动步数, b 为负向移动步数, 则有 a-b=target, sum=a+b
            //    如果 sum-target 是偶数, 则只需要减去一个偶数即可, 这个偶数必定满足 |x| < |k|
            //    1+2+3+...(k-1)+k = a+b = sum
            //                       a-b = target
            //    sum-target=2b, 因为sum加了一次b, 所以为了抵消, 这里是2b
            //    所以进行了 (n-1)次正向, 1次负向移动
            return n;
        } else {
            // 4. 如果 sum-target 是奇数
            // 4.1. 如果 n 为偶数, 那么 n+1 为奇数, 再多走一次, 则 (sum+n+1)-target 必定为偶数, 复用上面的例子
            // 4.2. 如果 n 为奇数, 那么 n+1 为偶数, 再多走两次, 则 (sum+n+1+n+2)-target 必定为偶数, 复用上面的例子
            return n % 2 == 0 ? n + 1 : n + 2;
        }
    }
}
