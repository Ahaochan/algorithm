package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 题目描述:
 * 请判断一个链表是否为回文链表。
 *
 * 解题思路
 * 快慢指针找到链表的中点
 * 翻转后半链表
 * 从头往后对比
 */
public class _0234_回文链表 {

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        Assert.assertFalse(isPalindrome(node1));
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(4); node4.next = node5;
        ListNode node6 = new ListNode(3); node5.next = node6;
        ListNode node7 = new ListNode(2); node6.next = node7;
        ListNode node8 = new ListNode(1); node7.next = node8;
        Assert.assertTrue(isPalindrome(node1));
    }

    @Test
    public void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(3); node4.next = node5;
        ListNode node6 = new ListNode(2); node5.next = node6;
        ListNode node7 = new ListNode(1); node6.next = node7;
        Assert.assertTrue(isPalindrome(node1));
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        // 1. 快慢指针找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 翻转后半链表
        ListNode node = slow.next;
        ListNode reverse = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = reverse;
            reverse = node;
            node = next;
        }
        slow.next = reverse;

        // 3. 从头往后对比
        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}
