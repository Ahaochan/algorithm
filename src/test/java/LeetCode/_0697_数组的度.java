package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * 题目描述:
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 解题思路
 */
public class _0697_数组的度 {
    @Test
    public void test1() {
        Assert.assertEquals(2, findShortestSubArray(1, 2, 2, 3, 1));
        Assert.assertEquals(6, findShortestSubArray(1, 2, 2, 3, 1, 4, 2));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24454426/
     * 执行用时 :11 ms, 在所有 Java 提交中击败了90.41%的用户
     * 内存消耗 :52.1 MB, 在所有 Java 提交中击败了18.88%的用户
     */
    public int findShortestSubArray(int... nums) {
        // 1. 找到最大的数字
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // 2. 创建 桶, count[i] 表示 i 出现的次数, left[i] 表示 i 在数组中最左边的下标, right[i] 同理.
        int[] count = new int[max + 1];
        int[] left  = new int[max + 1];
        int[] right = new int[max + 1];
        int maxCount = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            if(count[num] == 0) {
                left[num] = i;
            }
            right[num] = i;

            count[num]++;
            maxCount = Math.max(maxCount, count[num]);
        }

        // 3. 遍历比较
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= max; i++) {
            if(count[i] == maxCount) {
                result = Math.min(result, right[i]-left[i]+1);
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24452862/
     * 执行用时 :11 ms, 在所有 Java 提交中击败了90.41%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了96.67%的用户
     */
    public int findShortestSubArray_map(int... nums) {
        // 1. 统计每个数字为 key, {出现次数, 最左边的下标, 最右边的下标} 为 value
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] msg = map.get(nums[i]);
            if(msg == null) {
                msg = new int[3];
                map.put(nums[i], msg);
            }

            msg[0]++;
            if(msg[1] == 0) {
                msg[1] = i + 1; // +1 是为了避免 dirty case
            }
            msg[2] = i + 1;
        }

        // 2. 遍历比较
        int maxCount = 0, minLen = Integer.MAX_VALUE;
        for (int[] msg : map.values()) {
            int count = msg[0], left = msg[1], right = msg[2];
            if(count > maxCount) {
                maxCount = count;
                minLen = right - left + 1;
            } else if(count == maxCount){
                minLen = Math.min(minLen, right - left + 1);
            }
        }
        return minLen;
    }
}
