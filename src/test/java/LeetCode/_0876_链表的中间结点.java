package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 题目描述:
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 解题思路
 * 快慢指针
 */
public class _0876_链表的中间结点 {
    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;
        Assert.assertEquals(3, middleNode(node1).val);
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;
        ListNode node6 = new ListNode(6); node5.next = node6;
        Assert.assertEquals(4, middleNode(node1).val);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22087565/
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34 MB, 在所有 Java 提交中击败了56.92%的用户
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return slow;
    }
}
