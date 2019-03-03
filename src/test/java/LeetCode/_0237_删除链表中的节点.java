package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 题目描述:
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为: 4 5 1 9
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * 解题思路
 *
 */
public class _0237_删除链表中的节点 {

    @Test
    public void test1() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5); node1.next = node2;
        ListNode node3 = new ListNode(1); node2.next = node3;
        ListNode node4 = new ListNode(9); node3.next = node4;

        int[] expect = {4,1,9};
        deleteNode(node2);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], node1.val);
            node1 = node1.next;
        }
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5); node1.next = node2;
        ListNode node3 = new ListNode(1); node2.next = node3;
        ListNode node4 = new ListNode(9); node3.next = node4;

        int[] expect = {4,5,9};
        deleteNode(node3);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], node1.val);
            node1 = node1.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
