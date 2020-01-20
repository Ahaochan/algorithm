package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 题目描述:
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 解题思路
 * 先求链表长度, 然后简化k, 对切割点进行切割后拼接
 */
public class _0061_旋转链表 {
    @Test
    public void test1() {
        Assert.assertEquals(ListNode.createLink(1), rotateRight(ListNode.createLink(1), 1));
        Assert.assertEquals(ListNode.createLink(2,1), rotateRight(ListNode.createLink(1,2), 1));
        Assert.assertEquals(ListNode.createLink(1,2), rotateRight(ListNode.createLink(1,2), 2));
        Assert.assertEquals(ListNode.createLink(4,5,1,2,3), rotateRight(ListNode.createLink(1,2,3,4,5), 2));
        Assert.assertEquals(ListNode.createLink(2,0,1), rotateRight(ListNode.createLink(0,1,2), 4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/44126944/
     *
     * https://leetcode-cn.com/submissions/detail/44133924/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.94%的用户
     * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.01%的用户
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null; // dirty case

        // 1. 计算长度
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. 修正 k 值, 找到切割点
        k %= len;
        if (k <= 0) return head; // dirty case

        ListNode node = head;
        for (int i = 0, l = len - k - 1; i < l; i++) {
            node = node.next;
        }

        // 3. 旋转链表
        ListNode newHead = node.next;
        tail.next = head;
        node.next = null;
        return newHead;
    }
}
