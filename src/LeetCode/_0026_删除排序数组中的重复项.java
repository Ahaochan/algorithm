package LeetCode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 题目描述:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 解题思路
 * 用一个数组记录每个数字的偏移量, 然后再一步到位
 * 时间复杂度是O(n)
 *
 */
public class _0026_删除排序数组中的重复项 {
    public static void main(String[] args) {
        _0026_删除排序数组中的重复项 main = new _0026_删除排序数组中的重复项();
        System.out.println(main.removeDuplicates(1,1,2));
        System.out.println(main.removeDuplicates(0,0,1,1,1,2,2,3,3,4));
    }

    public int removeDuplicates(int... nums) {
        if(nums == null || nums.length <= 0) return 0;

        // 1. 偏移量数组
        int[] offset = new int[nums.length];
        int newLen = 1;

        // 2. 记录每个数字的偏移量
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]) {
                offset[i] = offset[i-1];
                newLen++;
            } else {
                offset[i] = offset[i-1] + 1;
            }
        }

        // 3. 一步到位
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]) {
                nums[i-offset[i]] = nums[i];
            }
        }
        return newLen;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "->" + (next != null ? next.toString() : null);
        }
    }
}
