package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 题目描述:
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 解题思路
 * 模拟题, 将每个数字回归到对应的下标, 再判断哪些下标的数字回归错误, 即可.
 *
 * 比如:
 * 4,3,2,7,8,2,3,1
 * 第一个元素4, 那么对应的位置的元素是7, 回归4, 多出个7 : 4,3,2,4,8,2,3,1 -> 7
 * 继续找7, 对应的位置的元素是3, 回归7, 多出个3: 4,3,2,4,8,2,7,1 -> 3
 * 继续找3, 对应的位置的元素是2, 回归3, 多出个2: 4,3,3,4,8,2,7,1 -> 2
 * 继续找2, 对应的位置的元素是3, 回归2, 多出个3: 4,2,3,4,8,2,7,1 -> 3
 * 继续找3, 发现3的位置上已经是3了, 则回归结束, 继续往后找, 找到下一个没有回归的元素
 * 下一个元素8, 那么对应的位置的元素是1, 回归8, 多出个1 : 4,2,3,4,8,2,7,8 -> 1
 * 继续找1, 对应的位置的元素是4, 回归1, 多出个4: 1,2,3,4,8,2,7,8 -> 4
 * 继续找4, 发现4的位置上已经是4了, 则回归结束, 继续往后找, 找到下一个没有回归的元素
 * 没有了, 那么可以看到, 1,2,3,4,8,2,7,8, 缺少的元素就是5,6
 */
public class _0448_找到所有数组中消失的数字 {
    @Test
    public void test() {
        List<Integer> expect = Arrays.asList(5,6);
        List<Integer> actual = findDisappearedNumbers(4,3,2,7,8,2,3,1);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19440427/
     * 执行用时 : 10 ms, 在Find All Numbers Disappeared in an Array的Java提交中击败了93.60% 的用户
     * 内存消耗 : 55.2 MB, 在Find All Numbers Disappeared in an Array的Java提交中击败了62.60% 的用户
     */
    public List<Integer> findDisappearedNumbers(int... nums) {
        int len = nums.length;
        // 1. 遍历每个元素
        for (int i = 0; i < len; i++) {
            int j = nums[i];

            // 2. 回归数字
            while (j != nums[j-1]) {
                int num = nums[j-1];
                nums[j-1] = j;
                j = num;
            }
        }

        // 3. 统计回归失败的数字
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(i + 1 != nums[i]) {
                result.add(i+1);
            }
        }
        return result;
    }
}
