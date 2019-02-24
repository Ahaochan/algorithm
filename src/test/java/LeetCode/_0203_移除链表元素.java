package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 题目描述:
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 解题思路
 * 遍历, 连接即可
 */
public class _0203_移除链表元素 {

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(6); node2.next = node3;
        ListNode node4 = new ListNode(3); node3.next = node4;
        ListNode node5 = new ListNode(4); node4.next = node5;
        ListNode node6 = new ListNode(5); node5.next = node6;
        ListNode node7 = new ListNode(6); node6.next = node7;

        int[] expect = {1, 2, 3, 4, 5};
        ListNode actual = removeElements(node1, 6);
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.val);
            actual = actual.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 1. 找到第一个值不为 val 的元素
        while(head != null && head.val == val) {
            head = head.next;
        }

        // 2. 移除后续的 val 值的元素
        ListNode node = head;
        while (node != null) {
            if(node.next != null && node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
