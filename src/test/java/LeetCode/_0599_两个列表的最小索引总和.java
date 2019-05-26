package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/submissions/
 * 题目描述:
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 解题思路
 * 先缓存 List1 中各个元素的索引, 记为 Map<String. Integer>
 * 然后遍历 list2, 取出交集元素索引, 求和
 */
public class _0599_两个列表的最小索引总和 {
    @Test
    public void test1() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] expect = {"Shogun"};
        Assert.assertArrayEquals(expect, findRestaurant(list1, list2));
    }

    @Test
    public void test2() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] expect = {"Shogun"};
        Assert.assertArrayEquals(expect, findRestaurant(list1, list2));
    }

    /**
     * 执行用时 : 19 ms, 在Minimum Index Sum of Two Lists的Java提交中击败了92.71% 的用户
     * 内存消耗 : 51.9 MB, 在Minimum Index Sum of Two Lists的Java提交中击败了50.64% 的用户
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 1. 记录 list1 各个元素的索引
        Map<String, Integer> index = new HashMap<>(list1.length);
        for (int index1 = 0, len = list1.length; index1 < len; index1++) {
            index.put(list1[index1], index1);
        }

        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int index2 = 0, len = list2.length; index2 < len; index2++) {
            // 2. 获取 list2 和 list1 的交集元素
            String item2 = list2[index2];
            Integer index1 = index.get(item2);
            if(index1 == null) {
                continue;
            }

            // 3. 对索引求和
            int sum = index1 + index2;
            if(sum < min) {
                // 3.1. 如果小于最小值, 则重新收集结果集
                min = sum;
                result.clear();
                result.add(item2);
            } else if(sum == min) {
                // 3.2. 如果等于最小值, 则收集结果
                result.add(item2);
            } // 3.3. 如果大于最小值, 则不处理
        }
        return result.toArray(new String[0]);

    }
}
