package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 题目描述:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 * 解题思路
 * 模拟加法运算
 */
public class _0002_两数相加 {


    @Test
    public void test1() {
        ListNode n1ode1 = new ListNode(2);
        ListNode n1ode2 = new ListNode(4);
        ListNode n1ode3 = new ListNode(3);
        n1ode1.next = n1ode2; n1ode2.next = n1ode3;
        ListNode n2ode1 = new ListNode(5);
        ListNode n2ode2 = new ListNode(6);
        ListNode n2ode3 = new ListNode(4);
        n2ode1.next = n2ode2; n2ode2.next = n2ode3;

        ListNode result = addTwoNumbers(n1ode1, n2ode1);
        Assert.assertEquals(7, result.val);
        Assert.assertEquals(0, result.next.val);
        Assert.assertEquals(8, result.next.next.val);
    }

    @Test
    public void test2() {
        ListNode n3ode1 = new ListNode(9);
        ListNode n3ode2 = new ListNode(9);
        n3ode1.next = n3ode2;
        ListNode n4ode1 = new ListNode(1);

        ListNode result = addTwoNumbers(n3ode1, n4ode1);
        Assert.assertEquals(0, result.val);
        Assert.assertEquals(0, result.next.val);
        Assert.assertEquals(1, result.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), node = head;

        int carry = 0;
        while(l1 != null || l2 != null) {
            // 1. 模拟加法, 进位
            int l1Num = l1 != null ? l1.val : 0;
            int l2Num = l2 != null ? l2.val : 0;
            int num = l1Num + l2Num + carry;
            carry = num / 10;
            num   = num % 10;

            // 2. 赋值到新节点
            node.next = new ListNode(num);
            node = node.next;

            // 3. 移动到下一位
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 处理 99+1 的情况
        if(carry != 0) {
            node.next = new ListNode(carry);
        }
        return head.next;
    }
}
