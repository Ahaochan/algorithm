package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 题目描述:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 解题思路
 * 遍历
 */
public class _0083_删除排序链表中的重复元素 {

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1); node1.next = node2;
        ListNode node3 = new ListNode(2); node2.next = node3;

        ListNode result = deleteDuplicates(node1);
        int[] expect = {1,2};
        for(int i = 0; i < expect.length; i++, result = result.next) {
            Assert.assertEquals(expect[i], result.val);
        }
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1); node1.next = node2;
        ListNode node3 = new ListNode(2); node2.next = node3;
        ListNode node4 = new ListNode(3); node3.next = node4;
        ListNode node5 = new ListNode(3); node4.next = node5;

        ListNode result = deleteDuplicates(node1);
        int[] expect = {1,2,3};
        for(int i = 0; i < expect.length; i++, result = result.next) {
            Assert.assertEquals(expect[i], result.val);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        for(ListNode pre = head, next = head.next; next != null; next = pre.next) {
            if(pre.val == next.val) {
                pre.next = next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}
