package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 题目描述:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 解题思路
 * 借助一个头指针, 简单题, 画图比较容易理解
 */
public class _0024_两两交换链表中的节点 {
    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;

        ListNode result = swapPairs(node1);
        int[] expect = {2,1,4,3};
        for (int i = 0; result.next != null; i++, result = result.next) {
            Assert.assertEquals(expect[i], result.val);
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23555499/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了85.61%的用户
     * 内存消耗 :35.2 MB, 在所有 Java 提交中击败了58.62%的用户
     */
    public ListNode swapPairs(ListNode head) {
        // 1. 借助一个头指针
        ListNode HEAD = new ListNode(-1);
        HEAD.next = head;

        // 2. 两两互换
        ListNode node = HEAD;
        while (node.next != null && node.next.next != null) {

            ListNode one = node.next;
            ListNode two = one.next;
            ListNode tail = two.next;

            node.next = two;
            two.next = one;
            one.next = tail;

            node = one;
        }

        return HEAD.next;
    }
}
