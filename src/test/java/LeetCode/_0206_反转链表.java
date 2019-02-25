package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 题目描述:
 * 反转一个单链表。
 *
 * 解题思路
 * 头插法
 */
public class _0206_反转链表 {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;

        int[] expect = {5,4,3,2,1};
        ListNode actual = reverseList(node1);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.val);
            actual = actual.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = reverse;
            reverse = head;

            head = next;
        }
        return reverse;
    }
}
