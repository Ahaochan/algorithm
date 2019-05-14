package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * 题目描述:
 * 写一个 RecentCounter 类来计算最近的请求。
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 * 返回从 3000 毫秒前到现在的 ping 数。
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * 解题思路
 * 题目比较难懂, 就是每次 ping 的时候, 都把时间存储下来, 计算 [t-3000, t] 之间的 ping 的次数
 * 用队列搞定
 */
public class _0933_最近的请求次数 {

    @Test
    public void test1() {
        RecentCounter obj = new RecentCounter();

        Assert.assertEquals(1, obj.ping(1));
        Assert.assertEquals(2, obj.ping(100));
        Assert.assertEquals(3, obj.ping(3001));
        Assert.assertEquals(3, obj.ping(3002));
    }

    /**
     * 执行用时 : 169 ms, 在Number of Recent Calls的Java提交中击败了56.90% 的用户
     * 内存消耗 : 65.8 MB, 在Number of Recent Calls的Java提交中击败了70.42% 的用户
     */
    class RecentCounter {
        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() == null || queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
