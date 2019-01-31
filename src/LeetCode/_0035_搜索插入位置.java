package LeetCode;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 题目描述:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 解题思路
 * 二分查找
 *
 */
public class _0035_搜索插入位置 {
    public static void main(String[] args) {
        _0035_搜索插入位置 main = new _0035_搜索插入位置();
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 0)); // 0
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
