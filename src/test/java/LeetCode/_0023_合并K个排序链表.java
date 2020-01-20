package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 题目描述:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 解题思路
 * 分治法
 *
 */
public class _0023_合并K个排序链表 {
    @Test
    public void test1() {
        Assert.assertEquals(ListNode.createLink(1, 1, 2, 3, 4, 4, 5, 6),
                mergeKLists(new ListNode[]{
                        ListNode.createLink(1, 4, 5),
                        ListNode.createLink(1, 3, 4),
                        ListNode.createLink(2, 6)}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/44122074/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了73.58%的用户
     * 内存消耗 :42.5 MB, 在所有 Java 提交中击败了41.39%的用户
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode link1 = merge(lists, left, mid);
        ListNode link2 = merge(lists, mid + 1, right);
        return mergeTwoLists(link1, link2);
    }

    public ListNode mergeTwoLists(ListNode link1, ListNode link2) {
        if (link1 == null) return link2;
        if (link2 == null) return link1;

        if (link1.val < link2.val) {
            link1.next = mergeTwoLists(link1.next, link2);
            return link1;
        } else {
            link2.next = mergeTwoLists(link1, link2.next);
            return link2;
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/44119633/
     * 执行用时 :457 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗 :56.5 MB, 在所有 Java 提交中击败了17.61%的用户
     */
    public ListNode mergeKLists_slow(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode node = head;

        int len = lists.length;
        while (anyNotNull(lists)) {
            int min = Integer.MAX_VALUE, minIdx = -1;
            for (int i = 0; i < len; i++) {
                if (lists[i] != null && min >= lists[i].val) {
                    min = lists[i].val;
                    minIdx = i;
                }
            }
            node.next = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;

            node = node.next;
        }
        return head.next;
    }

    public boolean anyNotNull(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) {
                return true;
            }
        }
        return false;
    }
}
