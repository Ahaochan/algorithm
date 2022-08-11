package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * 题目: https://leetcode.cn/problems/partition-list/
 * 题解: https://labuladong.github.io/algo/1/4/
 */
public class _0086_分隔链表 {

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(2); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;
        ListNode node6 = new ListNode(2); node5.next = node6;

        ListNode result = partition(node1, 3);
        int[] expect = {1,2,2,4,3,5};
        for(int i = 0; i < expect.length; i++, result = result.next) {
            Assert.assertEquals(expect[i], result.val);
        }
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1); node1.next = node2;

        ListNode result = partition(node1, 2);
        int[] expect = {1,2};
        for(int i = 0; i < expect.length; i++, result = result.next) {
            Assert.assertEquals(expect[i], result.val);
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1), node1 = dummy1;
        ListNode dummy2 = new ListNode(-1), node2 = dummy2;
        ListNode node = head;

        while (node != null) {
            if(node.val < x) {
                node1.next = node;
                node1 = node1.next;
            } else {
                node2.next = node;
                node2 = node2.next;
            }
            node = node.next;
        }

        node2.next = null;
        node1.next = dummy2.next;
        return dummy1.next;
    }
}
