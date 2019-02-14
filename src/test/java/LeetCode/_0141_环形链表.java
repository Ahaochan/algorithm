package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 题目描述:
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 解题思路
 *
 */
public class _0141_环形链表 {

    @Test
    public void test1() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(0); node2.next = node3;
        ListNode node4 = new ListNode(-4); node3.next = node4;
        node4.next = node2;

        Assert.assertTrue(hasCycle(node1));
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        node2.next = node1;

        Assert.assertTrue(hasCycle(node1));
    }

    @Test
    public void test3() {
        ListNode node1 = new ListNode(1);

        Assert.assertFalse(hasCycle(node1));
    }

    @Test
    public void test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;

        Assert.assertFalse(hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
