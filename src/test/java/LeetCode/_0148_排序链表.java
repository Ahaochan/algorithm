package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 题目描述:
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 解题思路
 * 用快慢指针找到中点，然后归并排序
 */
public class _0148_排序链表 {
    @Test
    public void test1() {
        Assert.assertEquals(ListNode.createLink(1, 2, 3, 4), sortList(ListNode.createLink(4, 2, 1, 3)));
        Assert.assertEquals(ListNode.createLink(-1, 0, 3, 4, 5), sortList(ListNode.createLink(-1, 5, 3, 4, 0)));
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了40.32%的用户
     * 内存消耗：47 MB, 在所有 Java 提交中击败了5.06%的用户
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next; // 链表第二部分的头节点
        slow.next = null; // cut 链表

        ListNode l = sortList(head);
        ListNode r = sortList(rightHead);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (l != null && r != null) {
            if (l.val > r.val) {
                cur.next = r;
                r = r.next;
            } else {
                cur.next = l;
                l = l.next;
            }
            cur = cur.next;
        }

        if (l != null) cur.next = l;
        if (r != null) cur.next = r;
        return head.next;
    }

    /**
     * 用空间换时间
     */
    public ListNode sortList_space(ListNode head) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (ListNode current = head; current != null; current = current.next) {
            max = Math.max(current.val, max);
            min = Math.min(current.val, min);
        }
        int[] bucket = new int[max - min + 1];
        for (ListNode current = head; current != null; current = current.next) {
            bucket[current.val - min]++;
        }
        ListNode current = head;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                current.val = i + min;
                current = current.next;
            }
        }
        return head;
    }
}
