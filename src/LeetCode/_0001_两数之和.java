package LeetCode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 题目描述:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 解题思路
 * 暴力两遍for循环, 时间复杂度O(n^2)
 *
 * 可以用时间换空间, 存储当前元素需要加上什么数才能等于 target
 * 比如 {2, 7, 11, 15}, target = 9
 * 对应的集合为 {7, 2, -2, -6}, 只要看对应的数在原数组中是否存在即可.
 */
public class _0001_两数之和 {
    public static void main(String[] args) {
        _0001_两数之和 main = new _0001_两数之和();
        int[] result = main.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + "," + result[1]); // 0,1
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }

            int num = target - nums[i];
            map.put(num, i);
        }
        return null;
    }
}
