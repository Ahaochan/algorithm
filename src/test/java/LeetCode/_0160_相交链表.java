package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 题目描述:
 * 编写一个程序，找到两个单链表相交的起始节点。
 *      a1 → a2 ↘
 *                c1 → c2 → c3
 * b1 → b2 → b3 ↗
 * 交点为c1
 *
 * 解题思路
 * 链表1和链表2的长度不相同, 那么就把链表1和链表2的长度加起来就相同了
 * 到达c3的时候, 指针1就从链表1尾换到链表2头, 指针2就从链表2尾换到链表1头
 */
public class _0160_相交链表 {

    @Test
    public void test1() {
        ListNode node_a1 = new ListNode(4);
        ListNode node_a2 = new ListNode(1); node_a1.next = node_a2;

        ListNode node_b1 = new ListNode(5);
        ListNode node_b2 = new ListNode(0); node_b1.next = node_b2;
        ListNode node_b3 = new ListNode(1); node_b2.next = node_b3;

        ListNode node_c1 = new ListNode(8); node_a2.next = node_c1; node_b3.next = node_c1;
        ListNode node_c2 = new ListNode(4); node_c1.next = node_c2;
        ListNode node_c3 = new ListNode(5); node_c2.next = node_c3;

        Assert.assertEquals(node_c1, getIntersectionNode(node_a1, node_b1));
    }

    @Test
    public void test2() {
        ListNode node_a1 = new ListNode(0);
        ListNode node_a2 = new ListNode(9); node_a1.next = node_a2;
        ListNode node_a3 = new ListNode(1); node_a2.next = node_a3;

        ListNode node_b1 = new ListNode(3);

        ListNode node_c1 = new ListNode(2); node_a3.next = node_c1; node_b1.next = node_c1;
        ListNode node_c2 = new ListNode(4); node_c1.next = node_c2;

        Assert.assertEquals(node_c1, getIntersectionNode(node_a1, node_b1));
    }

    @Test
    public void test3() {
        ListNode node_a1 = new ListNode(2);
        ListNode node_a2 = new ListNode(6); node_a1.next = node_a2;
        ListNode node_a3 = new ListNode(4); node_a2.next = node_a3;

        ListNode node_b1 = new ListNode(1);
        ListNode node_b2 = new ListNode(5); node_b1.next = node_b2;

        Assert.assertEquals(null, getIntersectionNode(node_a1, node_b1));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
