package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/task-scheduler/
 * 题目描述:
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 解题思路
 * 有两种情况,
 * 1. 最多任务只有一种
 * 2. 最多任务只有多种
 *
 * 最多任务只有一种, 比如 ABBCCC, 冷却时间有 n 秒
 * 那么必定有 C ... C ... CXXX, 那么中间必定有 n 个空槽 ... 要填充, 填充使用其他任务或着空置. 加上 C 就是 (n+1)
 * 假设最多任务的次数 ( 也就是 任务C 的次数 ) 有 maxCount 次, 则空槽的个数也可以得到是 (maxCount - 1).
 * 那么我们可以得到 C ... C ... 耗时 (n+1)*(maxCount-1),
 * 剩下后面的 CXXX, 在本例中应该是 C,
 * 也就是最终结果为 (n+1)*(maxCount-1) + 1
 *
 * 最多任务只有多种, 比如 AABBBCCC, 冷却时间有 n 秒
 * 那么必定有 C ... C ... CXXX, 那么中间必定有 n 个空槽 ... 要填充, 填充使用其他任务或着空置. 加上 C 就是 (n+1)
 * 假设最多任务的次数 ( 也就是 任务C 的次数 ) 有 maxCount 次, 则空槽的个数也可以得到是 (maxCount - 1).
 * 那么我们可以得到 C ... C ... 耗时 (n+1)*(maxCount-1), 到此和之前的步骤完全一致
 * 声息后面的 CXXX, 在本例中应该是 CB,
 * 也就是 最高频次的任务数量 concurrentMaxTask, 最终结果为 (n+1)*(maxCount-1) + concurrentMaxTask
 *
 */
public class _0621_任务调度器 {
    @Test
    public void test1() {
        Assert.assertEquals(8, leastInterval("AAABBB".toCharArray(), 2));
        Assert.assertEquals(6, leastInterval("ABBCCC".toCharArray(), 1));
    }

    public int leastInterval(char[] tasks, int n) {
        // 1. 统计每种任务的数量
        int[] counts = new int[26];
        for (int task : tasks) {
            counts[task - 65]++;
        }

        // 2. 统计最高频次任务数量
        int maxCount = 0;
        for (int count : counts) {
            maxCount = Math.max(maxCount, count);
        }

        // 2. 统计最高频次的任务数量
        int concurrentMaxTask = 0;
        for (int count : counts) {
            if(count == maxCount) {
                concurrentMaxTask++;
            }
        }

        // 3. 计算
        return Math.max(tasks.length, (maxCount-1)*(n+1)+concurrentMaxTask);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23152231/
     * 执行用时 :96 ms, 在所有 Java 提交中击败了6.01%的用户
     * 内存消耗 :50.8 MB, 在所有 Java 提交中击败了29.00%的用户
     */
    public int leastInterval_polling(char[] tasks, int n) {
        // 1. 统计每个任务的次数, 每个任务的冷却时间
        int[] counts = new int[26], cool = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        // 2. 每秒做的事情
        int allTaskCount = tasks.length, second = 0;
        while (allTaskCount > 0) {
            second++;

            // 2.1. 获取可以执行的任务
            char ch = 0; int maxCount = 0;
            for (int i = 0; i < 26; i++) {
                if(counts[i] > maxCount && cool[i] == 0) {
                    ch = (char) ('A' + i);
                    maxCount = counts[i];
                }
            }

            // 2.2. 如果有可以执行的任务, 则消费任务
            int idx = ch - 'A';
            if(idx >= 0) {
                counts[idx]--;
                cool[idx] = n;
                allTaskCount--;
            }

            // 2.3. 全体任务冷却时间减1
            for (int j = 0; j < 26; j++) {
                if(idx != j && cool[j] > 0) {
                    cool[j]--;
                }
            }
        }
        return second;
    }
}
