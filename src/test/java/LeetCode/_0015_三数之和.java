package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 题目描述:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 解题思路
 * 三指针遍历, 看注释
 */
public class _0015_三数之和 {

    @Test
    public void test1() {
        List<List<Integer>> actual = threeSum(-1, 0, 1, 2, -1, -4);
        int[][] expect = {{-1, -1, 2}, {-1, 0, 1}};
        for (int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[i].length; j++) {
                Assert.assertEquals(expect[i][j], actual.get(i).get(j).intValue());
            }
        }
    }

    @Test
    public void test2() {
        List<List<Integer>> actual = threeSum(0,0,0);
        int[][] expect = {{0,0,0}};
        for (int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[i].length; j++) {
                Assert.assertEquals(expect[i][j], actual.get(i).get(j).intValue());
            }
        }
    }

    @Test
    public void test3() {
        List<List<Integer>> actual = threeSum(-2,0,1,1,2);
        int[][] expect = {{-2,0,2},{-2,1,1}};
        for (int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[i].length; j++) {
                Assert.assertEquals(expect[i][j], actual.get(i).get(j).intValue());
            }
        }
    }

    /**
     * 执行用时 : 66 ms, 在3Sum的Java提交中击败了89.44% 的用户
     * 内存消耗 : 58.3 MB, 在3Sum的Java提交中击败了45.37% 的用户
     */
    public List<List<Integer>> threeSum(int... nums) {
        // 1. 先排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        // 2. 三指针, 确定左指针
        for(int l = 0; l < nums.length - 2; l++) {
            if(l > 0 && nums[l] == nums[l-1]) continue;

            // 3. 确定中、右指针, 然后遍历, 求和比较
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if(sum < 0) {
                    m++;
                } else if(sum > 0) {
                    r--;
                } else {
                    result.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    while (m < r && nums[m + 1] == nums[m]) m++;
                    while (m < r && nums[r - 1] == nums[r]) r--;
                    m++;
                    r--;
                }
            }
        }
        return result;
    }
}
